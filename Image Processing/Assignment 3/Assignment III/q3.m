function q3()

Img = imread('lena512.bmp');
negImg = imcomplement(Img);

subplot(1,2,1), imshow(Img);
subplot(1,2,2), imshow(negImg);