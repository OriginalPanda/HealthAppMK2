package sample;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class UserDatabase extends User
{
    private ArrayList<User> userArrayList;

    public void userDatabase()
    {
        BufferedReader bufferedReader = null;
        String fileName =  "Accounts.txt";
        try {
            userArrayList = new ArrayList<>();
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null)
            {
                String [] tokens = line.split(",");
                if (tokens.length > 0)
                {
                    String name = tokens[0]; //name
                    String surname = tokens[1];
                    String email = tokens[2];
                    String userName = tokens[3];
                    String password = tokens[4];
                    User user = new User(name,surname,email,userName,password);
                    userArrayList.add(user);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
    }


    // Checks to see in the username csv if there already is a username.
    public boolean usernameExists(String username)
    {
        for (User user :userArrayList)
        {
            if (user.getUserName() == username)
            {
                return true;
            }
        }
        return false;
    }

    public boolean emailExists(String email)
    {
        for (User user : userArrayList)
        {
            if (user.getEmail() == email)
            {
                return true;
            }

        }
        return false;
    }
    // Method that checks that the username is longer than 3 characters
    // and can only contain a-z, A-Z, 0-9, points, dashes and underscores.
    public boolean validUsername(String username)
    {
        if (!username.matches("[a-zA-Z0-9.\\-_]{3,}"))
        {
            return false;
        }
        if (!usernameExists(username))
        {
            return false;
        }
        return true;
    }

    // Method to add a user to the database only if the username is valid
    public void addUser(User user)
    {
        if(validUsername(user.getUserName()))
        {
            userArrayList.add(user);
        }
        else
        {
            System.out.println("Error invalid username");
        }
    }


    public static void main(String[] args)
    {

    }

}
