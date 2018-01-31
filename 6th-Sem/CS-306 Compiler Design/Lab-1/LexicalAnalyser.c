#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>


int main()
{
    char str[100];
    int num;
    int len;
    int i,j;
    scanf("%[^\n]s", str);
    ///printf("%s", str);
    int possibleVar = 0;
    int var = 0;
    ///taking input string --DONE

    /**
    * printf("\n%c", str[2]);
    * Accessing string elements --DONE
    */

    len = strlen(str);

    if( ((int)str[0] >= 65 && (int)str[0] <= 90) || ((int)str[0] >= 97 && (int)str[0] <= 122) )
    {
        possibleVar = 1;
    }

    if(possibleVar == 1)
    {
        for(i=1;i<len;i++)
        {
            if(!isdigit(str[i]) || !isalpha(str[i]))
            {
                var = 0;
                break;
            }
            var = 1;
        }
    }


    if(var == 1)
    {
        printf("\nIt is an Identifier");
    }
    else{
        printf("NO...!!!");
    }

    return 0;
}




