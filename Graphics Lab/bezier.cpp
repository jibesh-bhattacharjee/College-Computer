#include<iostream>
#include<vector>
#include<math.h>
#include<fstream>
using namespace std;
int n;
int canvas[500][500];
void plot(int x,int y)
{
    canvas[x][y]=0;
}
void brezier(int x[4],int y[4])
{   double t;
    for (t = 0.0; t < 1.0; t += 0.0005)
    {
        double xt = pow (1-t, 3) * x[0] + 3 * t * pow (1-t, 2) * x[1] +
                    3 * pow (t, 2) * (1-t) * x[2] + pow (t, 3) * x[3];

        double yt = pow (1-t, 3) * y[0] + 3 * t * pow (1-t, 2) * y[1] +
                    3 * pow (t, 2) * (1-t) * y[2] + pow (t, 3) * y[3];
       cout<<xt<<"    "<<yt<<endl;
       int xt2=xt+0.5;
       int yt2=yt+0.5;
       plot(xt2,yt2);
       //cout<<xt2<<"  "<<yt2<<endl;
    }

}
int main()
{
    fstream fp;
    fp.open("brezier.pgm",  ios::trunc|ios::out);
    cout<<"enter the no of control points: ";
    cin>>n;
    int x[n];
    int y[n];
    cout << "Now enter the points one by one:" << endl;
    for(int i=0; i<n; i++)
    {
        cin>>x[i]>>y[i];
        cout<<endl;
        plot(x[i],y[i]);
    }
    for(int i=0; i<500; i++)
    {
        for(int j=0; j<500; j++)
        {
            canvas[i][j]=255;
        }
    }
    brezier(x,y);
    ///printing out the output
    fp<<"P2\n"<<"500 500\n"<<"255\n";
    for(int j=499; j>=0; j--)
    {
        for(int i=0; i<500; i++)
        {
            fp<<canvas[i][j]<<" ";

        }

        fp<<"\n";

    }

    fp.close();
    return 0;
}
