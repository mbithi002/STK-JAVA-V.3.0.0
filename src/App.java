import java.util.Scanner;
public class App {

    private static User user1 = new User(0, 0, 100000, 0, 0);
    private static int phoneNumber = user1.get_phoneNumber();
    private static int mpesaPin = user1.get_mpesaPin();
    private static float mpesaBalance = user1.get_mpesaBalance();
    private static int airtimeBalance = user1.get_airtimeBalance();
    private static int dataBalance = user1.get_dataBalance();

    public static void main(String[] args) throws Exception {
        userSetting();
    }

    public static void userSetting() {
        System.out.println("Enter: \n1. Phone Number (Press Enter)\n2. M-Pesa PIN (Press Enter)\n");
        Scanner scanner = new Scanner(System.in);
        phoneNumber = scanner.nextInt();
        mpesaPin = scanner.nextInt();
        System.out.println("Success!\nPhone Number: " + phoneNumber + "\n");
        restart();
        scanner.close();
    }

    public static void menuOptions() {
        System.out.println(
                "Menu:\nSelect:\n1. Check Airtime Balance\n2. Purchase Airtime\n3. Check Data Balance\n4. Subscribe to Data Bundles\n5. Check Mpesa Balance\n6. Change My M-Pesa PIN\n");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // System.out.println("Fetching Airtime Balance...");
                checkAirtimeBalance();
                break;
            case 2:
                // System.out.println("Success purchase");
                purchaseAirtime();
                break;
            case 3:
                // System.out.println("Fetching Data Balance...");
                checkDataBalance();
                break;
            case 4:
                // System.out.println("Success! new Subscription");
                subscribeToDataBundle();
                break;
            case 5:
                // System.out.println("Fetching M-Pesa Balance...");
                checkMpesaBalance();
                break;
            case 6:
                // System.out.println("Success PIN Chenged");
                changePin();
                break;
            default: {
                System.out.println("Invalid Option!");
            }
        }

        scanner.close();

        restart();
    }

    public static void checkAirtimeBalance() {
        System.out.println("Airtime Balance: " + airtimeBalance + "KES\n");
        restart();
    }

    public static void purchaseAirtime() {
        System.out.println("Enter Your Phone Number: ");
        Scanner scanner = new Scanner(System.in);
        int inputPhone = scanner.nextInt();
        if (inputPhone == phoneNumber) {
            // success
            System.out.println("Enter Your PIN: ");
            int inputPin = scanner.nextInt();

            if (inputPin == mpesaPin) {
                // success
                System.out.println("Exsisting Airtime Balance: " + airtimeBalance + "KES\n" + "Enter Amount: ");
                int amount = scanner.nextInt();
                if (amount <= mpesaBalance) {
                    // success
                    airtimeBalance += amount;
                    mpesaBalance -= amount;

                    System.out.println("Success!\nAirtime Balance: " + airtimeBalance + "KES\n" + "M-Pesa Balance: "
                            + mpesaBalance + "KES\n");
                    restart();
                } else if (amount > mpesaBalance) {
                    // denied
                    System.out.println("Failed! Insufficient Airtime! Please Recharge Your Account. Please Try Again");
                    purchaseAirtime();
                }
            } else {
                // denied
                System.out.println("Incorrect PIN! Please Try Again.");
                purchaseAirtime();
            }
        } else {
            System.out.println("Incorrect Phone Number! Please Try Again");
            purchaseAirtime();
        }
        scanner.close();
    }

    public static void checkDataBalance() {
        System.out.println("Enter Phone Number: ");
        Scanner scanner = new Scanner(System.in);
        int inputPhone = scanner.nextInt();
        if (inputPhone == phoneNumber) {
            // success
            System.out.println("Data Balance : " + dataBalance + "MB\n");
            restart();
        } else {
            System.out.println("Incorrect Phone Number! Please Try Again");
            checkDataBalance();
        }
        scanner.close();
    }

    public static void subscribeToDataBundle() {
        System.out.println("Enter Your Phone Number: ");
        Scanner scanner = new Scanner(System.in);
        int inputPhone = scanner.nextInt();
        if (inputPhone == phoneNumber) {
            // success
            System.out.println("Enter Pin: ");
            int inputPin = scanner.nextInt();
            if (inputPin == mpesaPin) {
                // success
                System.out.println(
                        "Select: \n1. Daily(300MB 24HRS 20KES)\n2. Weekly (7000MB 7DAYS 300KES)\n3. Monthly(30000MB 30DAYS 1000KES)");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                    if(20 <= airtimeBalance) {
                        // success
                        dataBalance += 300;
                        airtimeBalance -= 20;
                        System.out.println("Success!\nData Balance: " + dataBalance + "MB\n" + "Airtime Balance: " + airtimeBalance + "KES\n");
                        restart();
                    } else {
                        // denied
                        System.out.println("Insufficient Airtime! Please Recharge Your Account");
                        restart();
                    }
                        break;
                    case 2:
                    if(300 <= airtimeBalance) {
                        // success
                        dataBalance += 7000;
                        airtimeBalance -= 300;
                        System.out.println("Success!\nData Balance: " + dataBalance + "MB\n" + "Airtime Balance: " + airtimeBalance + "KES\n");
                        restart();
                    } else {
                        // denied
                        System.out.println("Insufficient Airtime! Please Recharge Your Account");
                        restart();
                    }
                        break;
                    case 3:
                    if(20 <= airtimeBalance) {
                        // success
                        dataBalance += 30000;
                        airtimeBalance -= 1000;
                        System.out.println("Success!\nData Balance: " + dataBalance + "MB\n" + "Airtime Balance: " + airtimeBalance + "KES\n");
                        restart();
                    } else {
                        // denied
                        System.out.println("Insufficient Airtime! Please Recharge Your Account");
                        restart();
                    }
                        break;
                    default: {
                        System.out.println("Invalid Choice! Please Try Again");
                        subscribeToDataBundle();
                    }
                        break;
                }
                restart();
            } else {
                System.out.println("Incorrect PIN! Please Try Again");
                subscribeToDataBundle();
            }
        } else {
            System.out.println("Incorrect Phone Number! Please Try Again");
            subscribeToDataBundle();
        }
        scanner.close();
    }

    public static void checkMpesaBalance() {
        System.out.println("Enter Your Phone Number: ");
        Scanner scanner = new Scanner(System.in);
        int inputPhone = scanner.nextInt();
        if (inputPhone == phoneNumber) {
            // success
            System.out.println("Enter PIN: ");
            int inputPin = scanner.nextInt();
            if (inputPin == mpesaPin) {
                // success
                System.out.println("Dear Customer Your M-Pesa Balance is: " + mpesaBalance + "KEs\n");
                restart();
            }
        } else {
            // denied
            System.out.println("Incorrect Phone Number! Please Try Again");
            checkAirtimeBalance();
        }
        scanner.close();
    }

    public static void changePin() {
        System.out.println("Enter Your Old PIN: ");
        Scanner scanner = new Scanner(System.in);
        int inputPin = scanner.nextInt();
        if (inputPin == mpesaPin) {
            // success
            System.out.println("Enter New  PIN: ");
            int newPin = scanner.nextInt();
            mpesaPin = newPin;
            System.out.println("Success! PIN Changed\n");
            restart();
        } else {
            System.out.println("Icorrect PIN ! PLease try Again");
            changePin();
        }
        scanner.close();
    }

    public static void restart() {
        System.out.println("Select: \n1. To Continue\n2. To End Session");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                menuOptions();
                break;
            case 2:
                System.out.println("Session Ended Successfully.");
                break;
            default: {
                System.out.println("Invalid Option! Please Try Again");
                restart();
            }
        }
        scanner.close();
    }

}
