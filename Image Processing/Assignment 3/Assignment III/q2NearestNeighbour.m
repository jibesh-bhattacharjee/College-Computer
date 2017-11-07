function q2NearestNeighbour()

I = imread('lena512.bmp');

[j k] = size(I);

x_new = 1024;
y_new = 1024;

x_scale = x_new./(j-1);
 
y_scale = y_new./(k-1);

M = zeros(x_new,y_new);

for count1 = 0:x_new-1
 for count2 = 0:y_new-1
    M(count1+1,count2+1) = I(1+round(count1./x_scale),1+round(count2./y_scale));
 end
end

subplot(1,2,1), imshow(I);

%subplot(1,2,2), imshow(M)


%subplot(1,2,1); imagesc(I);
%colormap gray;
 
subplot(1,2,2), imagesc(M);
%colormap gray;
