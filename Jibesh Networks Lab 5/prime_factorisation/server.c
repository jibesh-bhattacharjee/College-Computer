#include<stdio.h>
#include<math.h>
#include<string.h> 
#include<sys/socket.h>
#include<arpa/inet.h> 
#include<unistd.h> 
#include<malloc.h>
int a[1000];
int k;
void prime(int n)
{
int i;
k=0;
for(i=0;i<1000;i++)
a[i]=0;

    while (n%2 == 0)
    {
        printf("%d\n",2);
	a[k]=2;
	k++;
        n = n/2;
    }
 
    for ( i = 3; i <=n; i = i+2)
    {
        while (n%i == 0)
        {
           printf("%d \n", i);
		a[k]=i;
		k++;
            n = n/i;
        }
    }
 
    if (n > 2)
        printf ("%d\n ", n);
	a[k]=n;
	k++;
}
 

int main(int argc , char *argv[])
{
 int socket_desc , client_sock , c , read_size;
 struct sockaddr_in server , client;
 int message,i;
 socket_desc = socket(AF_INET , SOCK_STREAM , 0);
 if (socket_desc == -1)
 {
 printf("Could not create socket");
 }
 puts("Socket created");
 server.sin_family = AF_INET;
 server.sin_addr.s_addr = INADDR_ANY;
 server.sin_port = htons( 8880 );
 if( bind(socket_desc,(struct sockaddr *)&server , sizeof(server)) < 0)
 {
 perror("bind failed. Error");
 return 1;
 }
 puts("bind done");
 listen(socket_desc , 3);
 puts("Waiting for incoming connections...");
 c = sizeof(struct sockaddr_in);
 client_sock = accept(socket_desc, (struct sockaddr *)&client, (socklen_t*)&c);
 if (client_sock < 0)
 {
 perror("accept failed");
 return 1;
 }
 puts("Connection accepted");
 
 while( (read_size = recv(client_sock ,&message , sizeof(int), 0)) > 0 )
 {
 puts("The number sent by client is: ");
 printf("%d\n",message);
int m[1000];
int q=0,j;
prime(message);
for(j=0;a[j]!=0;j++)
{

m[q]=a[j];
q++;
}
 
 write(client_sock , &m, sizeof(int)*q);

 }
 
 if(read_size == 0)
 {
 puts("Client disconnected");
 }
 else if(read_size == -1)
 {
 perror("recv failed");
 }
 
 return 0;
}
 

