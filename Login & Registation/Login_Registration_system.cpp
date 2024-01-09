#include<iostream> 
#include<fstream>
#include<string>

using namespace std;
string filepath = "Records.txt";

void signin();
void signup();
void forgot();

int main(){

  cout<<"\t\t*******************************************************"<<endl;
  cout<<"\t\t__________Welcome to your signin/signup page___________"<<endl;
  cout<<"\t\t_______________________________________________________"<<endl;
  cout<<"\t\tChoose your option"<<endl;
  cout<<"\t\t1. Signin"<<endl;
  cout<<"\t\t2. Signup"<<endl;
  cout<<"\t\t3. Forgot Password"<<endl;
  cout<<"\t\t4. Exit"<<endl;

  fstream file;
  try{
    file.open(filepath , ios::app);
    file.close();
  }catch(exception e){
    cout<<"File error " << e.what() <<endl;
  }

  int choice;
  cin>>choice;
  switch(choice){
    case 1:
    signin();
    break;

    case 2:
    signup();
    break;

    case 3:
    forgot();
    break;

    case 4:
    cout<<"Thank you for using our application"<<endl;
    return 0;

    default:
      cout<<"Invalid option ! Try Again\n\n"<<endl;
      main();
  }
}

void signin(){
  string username , password , txt;
  cout<<"Please enter username and password" <<endl;
  cout<<"Username : ";
  cin>>username;
  cout<<"Password : ";
  cin>>password;
  bool isAvail = false;

  ifstream file("Records.txt");
  while(getline(file , txt)){
    if(txt.find(username)!=string::npos){
      if(txt.find(password)!=string::npos){
          cout<<"Login Successfull\n"<<endl;
          isAvail = true;
          file.close();
          break;
      }else{
          cout<<"Incorrect Password ! Try Again\n"<<endl;
          main();
      }
    }
  }
  if(!isAvail){
    file.close();
    cout<<"User is not registered Please do registration first\n\n"<<endl;
  }
  main();
}

void signup(){
  string email , username , password , eid , id , pass;
  cout<<"Please enter eamil , username and password" <<endl;
  cout<<"Email : ";
  cin>>email;
  if(email.find('@')==string::npos){
    cout<<"Invalid Email ! Try Again\n"<<endl;
    main();
  }
  cout<<"Username : ";
  cin>>username;
  cout<<"Password : ";
  cin>>password;
  bool isAvail = false;
  fstream file( "Records.txt" , ios::in);
  file.close();
  file.open( "Records.txt" , ios::in);
  while(file>>eid){
    if(eid == email){
      cout<<"User already exists\n"<<endl;
      isAvail = true;
      file.close();
      break;
    }
  }
  file.close();
  file.open( "Records.txt" , ios::app);
  if(!isAvail){
    file<<email<<' '<<username<<' '<<password<<endl;
    file.close();
    cout<<"\tRegistration Successfull"<<endl;
    cout<<"\tThank You for Registration\n\n";
  }
  main();
}

void forgot(){
  cout<<"Enter your Email : ";
  string email , eid , id , pass;
  cin>>email;
  bool isAvail = false;
  ifstream file( "Records.txt" , ios::in);
  while(file>>eid>>id>>pass){
    if(eid == email){
      cout<<"Your Username : "<<id<<endl;
      cout<<"Your Password : "<<pass<<"\n"<<endl;
      file.close();
      isAvail = true;
      break;
    }
  }
  if(!isAvail){
    cout<<"User is not registered Please do registration first\n\n"<<endl;
    file.close();
  }
  main();
}
