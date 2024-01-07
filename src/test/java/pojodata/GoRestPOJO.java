package pojodata;

/**
 * Represents a POJO (Plain Old Java Object) for GoRest user data.
 */
public class GoRestPOJO {
    // Fields to store user data
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;

    // Constructors

    /**
     * Default constructor.
     */
    public GoRestPOJO() {
    }

    /**
     * Parameterized constructor to initialize user data.
     *
     * @param id     The user ID.
     * @param name   The user name.
     * @param email  The user email.
     * @param gender The user gender.
     * @param status The user status.
     */
    public GoRestPOJO(int id, String name, String email, String gender, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public GoRestPOJO(String name, String email, String gender, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }
    // Getter methods

    /**
     * Gets the user ID.
     *
     * @return The user ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the user name.
     *
     * @return The user name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the user email.
     *
     * @return The user email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user gender.
     *
     * @return The user gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets the user status.
     *
     * @return The user status.
     */
    public String getStatus() {
        return status;
    }

    // toString method for easy debugging and logging

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "GoRestPOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
