package logic.person;

public record Info<TaxNumber, Name, Email, CellPhoneNumber>
        (TaxNumber taxNumber, Name name, Email email, CellPhoneNumber cellPhoneNumber) {
}
