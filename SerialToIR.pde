

/*
October 2nd 2011
-P90Puma

Read serial data, take in hexadecimal values, convert into NEC iRDA communcation via an IR LED attached to PIN 3 on an Arduino UNO.

To be used mostly with the java app created to pass in serial input over WS/WSDL/SOAP.

*/

//imports and usages for the IRRemote library found at
// http://arcfn.com
#include <IRremote.h>
IRsend irsend;

void setup()
{
Serial.begin(9600); // begin serial communication
Serial.println("Convert hex serial inputs to NEC iRDA communication "); // debug string
}

int x; // integer x decalaraion
char p, *l; // declaration for charecter p and pointer to charecter l

void loop() //begin main loop
{ 
if (Serial.available()){
      //make sure we have all the data 
      delay(10);
      //serial data is waiting, lets extract      
      int i=0;      
      char X_buffer[9];
      while(i<10){
        X_buffer[i] = Serial.read();
        i++;
      }
      
      //flush serial buffer of extra data>9999
      Serial.flush();
      //convert numeric (hex) string to 'unsigned long int' variable
      unsigned long int necCode = strtoul(X_buffer,NULL,16);
      //debug messages
      Serial.println(X_buffer);
      Serial.println(necCode);
      
      //32 is the size of the NEC code in bits. Always use 32 for NEC.
      irsend.sendNEC(necCode,32);

    }
}
