function q4()

close all;
clear all;
F= imread('lena512.bmp');


C=input('Enter Value of C ');
gamma=input('Enter Value of gamma ');
 
        G=256-F;
        H=uint8(C.*log(double(1+F)));
        I=uint8(C.*((double(F)).^gamma));
    

subplot(2,2,1);
imshow(F);
title('Original Image');

subplot(2,2,2);
imshow(G);
title('Negative Operator');
 
subplot(2,2,3);
imshow(H);
logtext=sprintf('Log Img for C=%2.1f and gamma=%0.2f',C,gamma);
title(logtext);
 
subplot(2,2,4);
imshow(I);
powtext=sprintf('P.L Img for C=%2.1f and gamma=%0.2f',C,gamma);
title(powtext);