************************************************************************
   Student Numbers: ST10049393 - Mologadi Manyathela
                    ST10028317 - Abrar Hoque
                    ST10195811 - Mhlaba Mkhatshane
                    ST10169116 - Mcebisi Mape
                    ST10237815 - Lesedi Jantjies
                    ST10195540 - Caleb Baatjies  

   POE PART 2

   README on how to compile and run Miles App
************************************************************************
************************************************************************
*  CONTENTS:
************************************************************************

The Contents of this document contain the following:

1. The purpose of the app 
2. How to Compile and Run the Software
3. Design Consideration
4. Utilization of github and github actions


************************************************************************
* 1.  THE PURPOSE OF THE APP-
************************************************************************
    -This app is a travel planner that offers users a number of options to
    organize their trips and interfaces with Firebase for authentication. 
    The main parts of the app are as follows:

    User Authentication: The application uses Firebase Authentication for 
    user registration and login, and it also stores user data locally
    through shared preferences. Users can register, log in, and be
    redirected to different app functionalities upon successful 
    authentication.

    Search City Information: The app allows users to search for city-specific 
    data(hotels, restaurants, and attractions) via our own created API. 
    The information is displayed in a RecyclerView, providing users with 
    relevant details about their travel destinations.

    User Interaction: The software has capabilities that let users to
    organize their favorite vacation destinations in a wishlist and present
    different app functionalities on a home fragment.

    Settings and Preferences: Users can set up their preferences via a settings 
    fragment.

    -We have chosen to integrate only a single API, the geolocation API, 
    to avoid incurring additional costs. Utilizing multiple APIs would lead 
    to charges, whereas using just the geolocation API allows us to maintain 
    functionality without any associated fees.

**************************************************************************
* 2. HOW TO RUN AND COMPILE THE SOFTWARE
**************************************************************************
    1.Install Android Studio
    Download: Go to the Android Studio website and download the latest 
    version.
    Install: Follow the installation instructions for your operating system 
    (Windows, macOS, or Linux).
    2. Open the Android Studio.
    3. Use GitHub to get the application repository at 
       https://github.com/VCSTDN2024/opsc7312-part-2-nexatechsystems-squaremile.
       -Alternatively, you can unzip the 
       [opsc7312-part-2-nexatechsystems-squaremile-main] folder by 
       performing a right-click on the compressed folder and choosing 
       Extract All.

    4. Open the file in Android Studio, this can be done by:
         - Entering Android Studio, choosing File from the program's upper 
           left corner, choosing Open, and finally choosing Project. 
           After a menu appears, navigate to the location of the extracted 
           zipped folder, open it, and then open the 
           [opsc7312-part-2-nexatechsystems-squaremile-main] file.

         - An alternative method is to choose and open the 
           [opsc7312-part-2-nexatechsystems-squaremile-main] file by opening
           the extracted opsc7312-part-2-nexatechsystems-squaremile-main
            folder.

    5. Step 6: Set Up an Emulator or Device
       -Using an Emulator:
       Click on AVD Manager (Android Virtual Device).
       Create a new virtual device by choosing a hardware profile and system image.
       Start the emulator.
       -Using a Physical Device:
       Enable Developer Options on your device.
       Enable USB Debugging.
       Connect your device to your computer via USB.

    6.Run Your Project
    Click the green Run button (play icon) on the toolbar.
    Choose your device (emulator or physical phone) from the dialog that opens.
    To launch the application, click OK.
 
    7.It will automatically send you to the homepage. The user can see a list 
     of popular places they might wish to visit. On the search screen, the user
     enters the city in which they want to find locations. To utilize the 
     wishlist feature, the user must first register and log in. Once registered, 
     the user can add a list of destinations or restaurants that they would want
     to visit. On Settings, the user can change their app settings, including 
     their profile.
    
      
************************************************************************
3. DESIGN CONSIDERATION
************************************************************************
  
  1. User Authentication: Improve the user experience by combining secure 
     Firebase authentication with local data storage through shared
     preferences.
  
  2. Modular Architecture: Fragment-based design provides greater separation 
     of concerns, maintainability, and reusable code.

  3. Firebase Integration: Scalable cloud storage and real-time synchronization
     of user data.

  4. Network Operations: Efficient API calls using Retrofit to retrieve 
     city-specific data.

  5. User Experience: RecyclerView allows for smooth navigation and improved 
     performance while processing huge collections.

  6. Offline Capabilities: Local data storage and syncing enable offline use.

  7. API Cost Management: The geolocation API is utilized to maintain 
     functionality while reducing expenses.


*****************************************************************************
* UTILISATION OF GITHUB AND GITHUB ACTIONS
*****************************************************************************
-We utilized GitHub to collaborate by committing, pushing, and pulling code 
to keep our project up to date and easily accessible to everyone in the group

GitHub Repository Link
https:https://github.com/VCSTDN2024/opsc7312-part-2-nexatechsystems-squaremile

Link To the Video (user can listen to an audio after or while watching the streaming)
https://advtechonline-my.sharepoint.com/:v:/g/personal/st10195811_vcconnect_edu_za/EZk4V-dlQ11EkUvvk-yxZckBgM_cY1XN1tOgV8bzhw72Vg?e=crO6eP&nav=eyJwbGF5YmFja09wdGlvbnMiOnt9LCJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbE1vZGUiOiJtaXMiLCJyZWZlcnJhbFZpZXciOiJwb3N0cm9sbC1jb3B5bGluayIsInJlZmVycmFsUGxheWJhY2tTZXNzaW9uSWQiOiI0MTE4MWJhZC1kMWJiLTQxZmQtOWM3NC1mNjY3ZWE0MDMyMzQifX0%3D
******************************************************************************
