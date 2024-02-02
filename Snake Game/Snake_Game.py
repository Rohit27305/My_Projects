import pygame
import sys
import random


# Initialize pygame
pygame.init()

# Constants
WIDTH, HEIGHT = 600, 400
GRID_SIZE = 20
SNAKE_SIZE = 20
FPS = 10

# Colors
WHITE = (255, 255, 255)
RED = (255, 0, 0)
GREEN = (0, 255, 0)

# Initialize the screen
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Snake Game")

# Snake initial position and direction
snake = [(100, 100), (90, 100), (80, 100)]
snake_direction = (GRID_SIZE, 0)

# Initial position of the food
food = (random.randint(0, (WIDTH - GRID_SIZE) // GRID_SIZE) * GRID_SIZE,
        random.randint(0, (HEIGHT - GRID_SIZE) // GRID_SIZE) * GRID_SIZE)

# Score
score = 0

# Function to display text on the screen
def display_text(text, size, color, x, y):
    font = pygame.font.Font(None, size)
    text_surface = font.render(text, True, color)
    screen.blit(text_surface, (x, y))

# Main game loop
clock = pygame.time.Clock()

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_UP and snake_direction != (0, GRID_SIZE):
                snake_direction = (0, -GRID_SIZE)
            elif event.key == pygame.K_DOWN and snake_direction != (0, -GRID_SIZE):
                snake_direction = (0, GRID_SIZE)
            elif event.key == pygame.K_LEFT and snake_direction != (GRID_SIZE, 0):
                snake_direction = (-GRID_SIZE, 0)
            elif event.key == pygame.K_RIGHT and snake_direction != (-GRID_SIZE, 0):
                snake_direction = (GRID_SIZE, 0)

    # Move the snake
    new_head = (snake[0][0] + snake_direction[0], snake[0][1] + snake_direction[1])
    snake = [new_head] + snake[:-1]

    # Check for collisions with the walls
    if new_head[0] < 0 or new_head[0] >= WIDTH or new_head[1] < 0 or new_head[1] >= HEIGHT:
        pygame.quit()
        print("Your Score : ", score)
        sys.exit()

    # Check for collisions with itself
    if new_head in snake[1:]:
        pygame.quit()
        print("Your Score : " , score)
        sys.exit()

    # Check if the snake eats the food
    if new_head == food:
        snake.append(snake[-1])  # Grow the snake
        food = (random.randint(0, (WIDTH - GRID_SIZE) // GRID_SIZE) * GRID_SIZE,
                random.randint(0, (HEIGHT - GRID_SIZE) // GRID_SIZE) * GRID_SIZE)
        score += 1

    # Draw the background
    screen.fill(WHITE)

    # Draw the snake
    for segment in snake:
        pygame.draw.rect(screen, GREEN, (segment[0], segment[1], SNAKE_SIZE, SNAKE_SIZE))

    # Draw the food
    pygame.draw.rect(screen, RED, (food[0], food[1], SNAKE_SIZE, SNAKE_SIZE))

    # Display the score
    display_text("Score: {}".format(score), 24, GREEN, 10, 10)

    pygame.display.flip()
    clock.tick()
    clock.tick(FPS)


