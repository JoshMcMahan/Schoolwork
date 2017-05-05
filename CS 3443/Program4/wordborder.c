#include <stdio.h>

int main() {
    printf("Joshua McMahan\n");
    printf("Please enter a word: ");

    char user_In[64];
    scanf("%s", user_In);


    int i = 0;
    while(user_In[i] != '\0'){
        i++;
    }
    int j = 0;
    while ( j <= i + 1) {
        printf("*");
        j++;
    }
    printf("\n");
    printf("*");
    printf(user_In);
    printf("*");
    printf("\n");
    j = 0;
    while ( j <= i + 1) {
        printf("*");
        j++;
    }

    return 0;
}