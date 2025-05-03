package id.com.anisatrilestari.customer;

// Response DTO untuk mengembalikan data pelanggan ke client
public record CustomerDetailsResponse(
        Long id,
        String name,
        String phoneNumber) {

    // Konstruktor untuk mengisi data dari entitas Customer
    public CustomerDetailsResponse(Customer customer) {
        this(
                customer.getId(),
                customer.getName(),
                customer.getPhoneNumber()
        );
    }
}
