package Lab1.Entities.CommandHandler;

import Lab1.Entities.Bank.Bank;
import Lab1.Models.Client.Client;
import Lab1.Models.ValueObjects.Name;
import Lab1.Models.ValueObjects.Surname;
import Lab1.Services.SearchEngine;
import Lab1.Services.Validator;

import java.util.Scanner;

public class AddClientCommandHandler extends CommandHandler {
    private final Bank bank;
    private final Scanner scanner;

    public AddClientCommandHandler(Bank bank) {
        Validator.checkIfNull(bank);

        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 1;
    }

    @Override
    public void processCommand(int choice) {
        System.out.print("Введите имя клиента: ");
        String firstName = scanner.next();

        System.out.print("Введите фамилию клиента: ");
        String surName = scanner.next();

        Client client = new Client(new Name(firstName), new Surname(surName));

        if (SearchEngine.checkIfClientExists(client, bank)) {
            System.out.println("Такой клиент уже существует!");
        } else {
            bank.addClient(client);

            System.out.println("Клиент успешно добавлен");
        }
    }
}
