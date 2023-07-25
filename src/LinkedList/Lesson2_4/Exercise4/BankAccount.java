package LinkedList.Lesson2_4.Exercise4;

import java.util.Objects;

public class BankAccount {
    private String fullName;
    private String numberId;
    private String numberAccount;
    private String nameBank;
    private float surplus;

    public BankAccount() {
    }

    public BankAccount(String fullName, String numberId,
                       String numberAccount, String nameBank,
                       float surplus) {
        this.fullName = fullName;
        this.numberId = numberId;
        this.numberAccount = numberAccount;
        this.nameBank = nameBank;
        this.surplus = surplus;
    }

    public BankAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public float getSurplus() {
        return surplus;
    }

    public void setSurplus(float surplus) {
        this.surplus = surplus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(numberAccount, that.numberAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberAccount);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "fullName='" + fullName + '\'' +
                ", numberId='" + numberId + '\'' +
                ", numberAccount='" + numberAccount + '\'' +
                ", nameBank='" + nameBank + '\'' +
                ", surplus=" + surplus +
                '}';
    }
}
