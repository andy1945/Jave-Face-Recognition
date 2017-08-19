# Jave-Face-Recognition
This is a java face desktop application. Its purpose is to recognize faces in real-time.  I added a small database where i could demo its use case. For example for payment ,someones needs to be recognized by face to process their payment. It can be used for many other use cases. The main goal is to make it better and standout. Any one who can help contribute to the code is very welcome. 


We first register someone in a small db and we store their three or four faces which will be trained.
Note: It's useful to include several pictures of the same face showing different expressions, such as smiling and frowning.
Each training image can be represented by a weighted sequence of eigenfaces.

![like below](https://support.mobisquid.com/images/profile/screenone.png)

So when we want to verify them we select verify from the menu.
We open the camera and in the backgroud we generate eigenfaces.
The currently selected face is compared against a set of images that the recognizer code has been trained against.

![Like](http://support.mobisquid.com/images/profile/screen3.png)

![All resources from the big man Andrew Davison](http://fivedots.coe.psu.ac.th/~ad/index.html)

![Using his book Killer Game Programming in Java](http://fivedots.coe.psu.ac.th/~ad/jg/??)

I made use of some libs like colt,opencv javacv



