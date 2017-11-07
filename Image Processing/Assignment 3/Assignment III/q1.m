function q1()

f = imread('lena512.bmp');
f5 = f / 128;
f3 = f / 8;
f1 = f / 2;

%imshow(f5);
%figure, imshow(f3);
%figure, imshow(f1);

subplot(1,3,1), imshow(f5)
subplot(1,3,2), imshow(f3)
subplot(1,3,3), imshow(f1)