#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <stdio.h>
#include<string.h>
#include <unistd.h>
#include <arpa/inet.h>
int main(int argc,char **argv)
{
	int sockfd,n,n2,i,buffer,buffer2,buffer3;
	float buffer4,buffer5;
    	char sendline[100];
    	char recvline[100],word[50],meaning[50];
    	struct sockaddr_in servaddr;

    	sockfd=socket(AF_INET,SOCK_STREAM,0);
    	bzero(&servaddr,sizeof servaddr);

    	servaddr.sin_family=AF_INET;
    	servaddr.sin_port=htons(22000);

    	inet_pton(AF_INET,"127.0.0.1",&(servaddr.sin_addr));

    	connect(sockfd,(struct sockaddr *)&servaddr,sizeof(servaddr));
  	

	bzero( recvline, 100);
        read(sockfd,recvline,100);
        printf("%s",recvline);
	scanf("%s",&word);
	write(sockfd,&word,sizeof(word));

	
	read(sockfd,meaning,50);
	printf("The meaning is: %s\n");

	close(sockfd);

	return 0;
	
}
