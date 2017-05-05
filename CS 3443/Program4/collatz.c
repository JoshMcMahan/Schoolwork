#include <stdio.h>

int main() {
    printf("Joshua McMahan\n");
    printf("Please enter any positive integer. \n");
    int user_In;
    scanf("%d", &user_In);
    while (user_In != 1) {
        if (user_In % 2 == 0) {
            user_In = user_In / 2;
            printf("%d\n", user_In);
        } else {
            user_In = user_In * 3 + 1;
            printf("%d\n", user_In);
        }
    }
    return 0;
}