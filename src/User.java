
public class User {
  private int _phoneNumber;
  private int _mpesaPin;
  private float _mpesaBalance;
  private int _airtimeBalance;
  private int _dataBalance;

  public User (int phoneNumber, int mpesaPin, float mpesaBalance, int airtimeBalance, int dataBalance) {
    _phoneNumber = phoneNumber;
    _mpesaPin = mpesaPin;
    _mpesaBalance = mpesaBalance;
    _airtimeBalance = airtimeBalance;
    _dataBalance = dataBalance;
  }

  public void set_phoneNumber (int phoneNumber) {
    _phoneNumber = phoneNumber;
  }

  public int get_phoneNumber () {
    return _phoneNumber;
  }

  public void set_mpesaPin (int mpesaPin) {
    _mpesaPin = mpesaPin;
  }

  public int get_mpesaPin () {
    return _mpesaPin;
  }

  public void set_mpesaBalance (float mpesaBalance) {
    _mpesaBalance = mpesaBalance;
  }

  public float get_mpesaBalance () {
    return _mpesaBalance;
  }

  public void set_airtimeBalance (int airtimeBalance) {
    _airtimeBalance = airtimeBalance;
  }

  public int get_airtimeBalance () {
    return _airtimeBalance;
  }

  public void set_dataBalance (int dataBalance) {
    _dataBalance = dataBalance;
  }

  public int get_dataBalance () {
    return _dataBalance;
  }
}
