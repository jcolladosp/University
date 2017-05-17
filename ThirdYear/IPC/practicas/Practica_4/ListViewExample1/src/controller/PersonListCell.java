/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.scene.control.ListCell;
import model.Person;

/**
 *
 * @author colla
 */
class PersonListCell extends ListCell<Person>
{
    @Override
    protected void updateItem(Person item, boolean empty)
    { super.updateItem(item, empty); // This is mandatory
        if (item==null || empty) setText(null);
        else setText(item.getFirstName() +" " + item.getLastName());
    }
}

