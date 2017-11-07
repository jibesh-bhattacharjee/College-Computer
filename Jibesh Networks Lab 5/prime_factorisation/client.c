#include<stdio.h> 
#include<string.h> 
#include<sys/socket.h> 
#include<arpa/inet.h> 
int main(int argc , char *argv[])
{

 int sock;
 struct sockaddr_in server;
 int number,i,temp;
 //Create socket
 sock = socket(AF_INET,SOCK_STREAM,0);
 if (sock == -1)
 {
 printf("Could not create socket");
 }
 puts("Socket created");
 
 server.sin_addr.s_addr = inet_addr("127.0.0.1");
 server.sin_family = AF_INET;
 server.sin_port = htons( 8880 );
 
 //Connect to remote server
 if (connect(sock , (struct sockaddr *)&server , sizeof(server)) < 0)
 {
 perror("connect failed. Error");
 return 1;
 }
ll:
 puts("Connected\n");

 printf("Enter a number: ");
 scanf("%d",&temp);

 int server_reply[1000];
 
 if( send(sock , &temp, sizeof(int) , 0) < 0)
 {
 puts("Send failed");
 return 1;
 }
 
 if( recv(sock , &server_reply , sizeof(int)*1000, 0) < 0)
 {
 puts("recv failed");
 return;
 }
 puts("Server reply:\n");
int y,e,t=0;
for(e=0;e<1000;e++)
{
if(server_reply[e]!=0)
t++;
else break;
}

for( y=0;y<t-1;y++){
printf("%d",server_reply[y]);
if(y!=t-2)
printf("*");
 }
char dd; 
puts("\n Do you want to close the connection?(1/0)");
scanf("%d",&dd);
if(dd==1){
puts("Disconnected\n");
 close(sock);
}
else{
goto ll;
}
}
