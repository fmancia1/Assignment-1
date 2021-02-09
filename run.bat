set PATH_TO_FX="C:\javafx-sdk-15.0.1\lib"
javac --module-path %PATH_TO_FX% --add-modules javafx.controls InvalidSequenceException.java LengthException.java NoDigitException.java NoLowerAlphaException.java NoSpecialCharacterException.java NoUpperAlphaException.java  PasswordCheckerUtility.java PasswordDriverFX.java PasswordMain.java UnmatchedException.java WeakPasswordException.java
java --module-path %PATH_TO_FX% --add-modules javafx.controls -cp C:\Users\fvman\Downloads\Assignment1_CMSC-204-402\Assignment1 PasswordDriverFX
timeout /t -1
