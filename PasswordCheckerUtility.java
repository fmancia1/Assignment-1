/**
* This is the PasswordCheckerUtility class
*
*
* @author Fatima Mancia
*
*/
import java.util.regex.*;
import java.util.ArrayList;

class PasswordCheckerUtility{
  private static ArrayList<String> invalidPasswords;
  public String password;
  public String passwordConfirm;
  public PasswordCheckerUtility(){

  }
  /**
	 * comparePasswords compares the password with the checking password box
	 * @param password one of the variables that is going to be compared
	 * @param passwordConfirm is the other variable that is going to be compared
	 *
	 */
  public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
    if (!password.equals(passwordConfirm)){
      throw new UnmatchedException("Password do not match");
    }
  }
  /**
	 * comparePasswords compares the password with the checking password box
	 * @param password one of the variables that is going to be compared
	 * @param passwordConfirm is the other variable that is going to be compared
	 *@return returns true if the passwords are equal. False if not
	 */
  public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
    if (password.equals(passwordConfirm)){
      return true;
    }
    else {
      return false;
    }
  }
  /**
	 * comparePasswords compares the password with the checking password box
	 * @param password the ones that are going to be listed
	 * @return the list of invalid passwords
	 *
	 */
  public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
    return invalidPasswords;
  }
  /**
	 * comparePasswords compares the password with the checking password box
	 * @param password variable that is going to be measure
	 * @return if the password length is between 6 and 9 returns true. If not false
	 *
	 */
  public static boolean hasBetweenSixAndNineChars(String password){
    if (password.length() >= 6 && password.length() <= 9){
      return true;
    }
    else {
      return false;
    }
  }
  /**
	 * comparePasswords compares the password with the checking password box
	 * @param password one of the variables that has or not a digit
	 * @return if the password has a digit true. If not throws Exception
	 *
	 */
  public static boolean hasDigit(String password) throws NoDigitException{
   for (int i = 0; i < password.length(); i++){
     if(Character.isDigit(password.charAt(i))){
       return true;
     }
   }
   throw new NoDigitException("Does not meet digit requirement");
  }
  /**
	 * comparePasswords compares the password with the checking password box
	 * @param password one of the variables that is going to be checked if it has a lower case letter
	 * @return if includes a lowercase true. If not throws Exception
	 *
	 */
  public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
    for (int i = 0; i < password.length(); i++){
      if(Character.isLowerCase(password.charAt(i))){
        return true;
      }
    }
    throw new NoLowerAlphaException("Does not meet lowercase requirement");
  }
  /**
	 * comparePasswords compares the password with the checking password box
	 * @param password one of the variables that is going to be checked if it has same character sequence
	 * @return if meets the sequence requirement returns true. If not throws Exception
	 *
	 */
  public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException{
    int alphaCounter = 0;
    int digitCounter = 0;
    int specialCounter = 0;
    for (int i = 0; i < password.length(); i++) {
      if (Character.isAlphabetic(password.charAt(i))) {
        digitCounter = 0;
        specialCounter = 0;
        alphaCounter++;
        if (alphaCounter > 2) {
          throw new InvalidSequenceException("Does not meet the sequence requirement");
        }
      }
      else if (Character.isDigit(password.charAt(i))) {
        alphaCounter = 0;
        specialCounter = 0;
        digitCounter++;
        if (digitCounter > 2) {
         throw new InvalidSequenceException("Does not meet the sequence requirement");
        }
      }
      else {
        alphaCounter = 0;
        digitCounter = 0;
        specialCounter++;
        if (specialCounter > 2) {
          throw new InvalidSequenceException("Does not meet the sequence requirement");
        }
      }
    }
    return true;
  }
  /**
	 * comparePasswords compares the password with the checking password box
	 * @param password one of the variables that is going to be checked if it has special character
	 * @return if it has a special character returns true. If not throws Exception
	 *
	 */
  public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
   Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
      throw new NoSpecialCharacterException("Does not meet Special Character requirement");
    }
    return true;
  }
  /**
	 * comparePasswords compares the password with the checking password box
	 * @param password one of the variables that is going to be checked if it has a upper case letter
	 * @return if includes a uppercase true. If not throws Exception
	 *
	 */
  public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
    for (int i = 0; i < password.length(); i++){
      if(Character.isUpperCase(password.charAt(i))){
        return true;
      }
    }
    throw new NoUpperAlphaException("Does not meet alpha character requirement");
  }
  /**
	 * comparePasswords compares the password with the checking password box
	 * @param password is going to be checked if it has the valid length
	 * @return if includes a lowercase true. If not throws Exception
	 *
	 */
  public static boolean isValidLength(String password) throws LengthException{
    if(password.length() >= 6) {
      return true;
    }
    else {
      throw new LengthException("Does not meet length requirement");
    }
  }
  /**
   * comparePasswords compares the password with the checking password box
   * @param password is going to be checked if it is valid
   * @return if includes all the requirements returns true. If not throws Exception
   *
   */
  public static boolean isValidPassword(String password) throws LengthException,
   NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException,InvalidSequenceException{
     if (
       (isValidLength(password) == true) &&
       (hasUpperAlpha(password) == true) &&
       (hasLowerAlpha(password) == true) && (hasDigit(password) == true) && (hasSpecialChar(password) == true) && (hasSameCharInSequence(password) == true)){
         return true;
       }
     else {
       return false;
     }
   }
   /**
   * comparePasswords compares the password with the checking password box
   * @param password is going to be checked if it between 6 and 9 characters
   * @return if includes between 6 and 9 return true. If not throws Exception
   *
   */
  public static boolean isWeakPassword(String password) throws WeakPasswordException{
    if (hasBetweenSixAndNineChars(password) == true){
      return true;
    }
    else {
      throw new WeakPasswordException("Weak password");
    }
  }
}
