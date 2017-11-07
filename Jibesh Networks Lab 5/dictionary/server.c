#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <stdio.h>
#include<string.h>
#include <unistd.h>
#include<stdlib.h>
struct dictionary
{
	char word[50];
	char meaning[50];
};
struct dictionary di[20];
void data()
{
strcpy (di[0].word,"vain");
strcpy (di[0].meaning,"unproductive of success");
strcpy (di[1].word,"coast");
strcpy (di[1].meaning,"the shore of a sea or ocean");
strcpy (di[2].word,"affect");
strcpy (di[2].meaning,"have an influence upon");
strcpy (di[3].word,"league");
strcpy (di[3].meaning,"an association of sports teams that organizes matches");
strcpy (di[4].word,"confer");
strcpy (di[4].meaning,"have a meeting in order to talk something over");
strcpy (di[5].word," dwell");
strcpy (di[5].meaning,"think moodily or anxiously about something");
strcpy (di[6].word,"yield");
strcpy (di[6].meaning,"give or supply");
strcpy (di[7].word,"wander");
strcpy (di[7].meaning,"move or cause to move in a sinuous or circular course");
strcpy (di[8].word,"knight");
strcpy (di[8].meaning,"a person of noble birth trained to arms and chivalry");
strcpy (di[9].word,"furnish");
strcpy (di[9].meaning,"provide with objects or articles that make a room usable");
strcpy (di[10].word,"persist");
strcpy (di[10].meaning,"continue to exist");
strcpy (di[11].word,"tour");
strcpy (di[11].meaning,"a route all the way around a particular place or area");
strcpy (di[12].word,"weigh");
strcpy (di[12].meaning,"be oppressive or burdensome");
strcpy (di[13].word,"exert");
strcpy (di[13].meaning,"make a great effort at a mental or physical task");
strcpy (di[14].word,"oppress");
strcpy (di[14].meaning,"come down on or keep down by unjust use of one's authority");
strcpy (di[15].word,"contend");
strcpy (di[15].meaning,"compete for something");
strcpy (di[16].word,"perish");
strcpy (di[16].meaning,"pass from physical life");
strcpy (di[17].word,"rail");
strcpy (di[17].meaning,"complain bitterly");
strcpy (di[18].word,"bestow");
strcpy (di[18].meaning,"present");
strcpy (di[19].word,"allege");
strcpy (di[19].meaning,"report or maintain");
}
void check(char buffer[],char buffer2[])
{
int i,flag=0;
	for(i=0;i<20;i++)
	{
		if(!strcmp(di[i].word,buffer))
		{
			strcpy(buffer2,di[i].meaning);
			flag=0;
			i=20;
		}
		else
		{
			flag=1;
		}
	}
	if(flag==1)
	{
		strcpy(di[21].word,buffer);
		printf("Enter the meaning: ");
		fgets(buffer2,50,stdin);
	}
}
int main()
{
	char str[100],buffer[50],buffer2[50];
    	int listen_fd, comm_fd,flag=1;
 	struct sockaddr_in servaddr;
	data();
    	listen_fd = socket(AF_INET, SOCK_STREAM, 0);
 	bzero( &servaddr, sizeof(servaddr));
    	servaddr.sin_family = AF_INET;
    	servaddr.sin_addr.s_addr = htons(INADDR_ANY);
    	servaddr.sin_port = htons(22000);

    	bind(listen_fd, (struct sockaddr *) &servaddr, sizeof(servaddr));
 	listen(listen_fd, 10);
	comm_fd = accept(listen_fd, (struct sockaddr*) NULL, NULL);
	printf("Client Connected!!!!\n");
        	bzero( str, 100);

		while(1)
		{
		strcat(str,"Enter the word:");
        write(comm_fd, str, strlen(str)+1);
		read(comm_fd,&buffer,sizeof(buffer));
		printf("The word received from client is: %s\n",buffer);
		check(buffer,buffer2);
		write(comm_fd, buffer2, strlen(buffer2)+1);
		}

	close(listen_fd);

	return 0;
}
