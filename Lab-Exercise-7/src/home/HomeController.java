package home;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class HomeController implements Initializable{
    
    @FXML
    private TextField name;
    @FXML
    private TextField department;
    
    @FXML
    private TableView<EmployeeData> employeeDataTableView;
    @FXML
    private TableColumn<EmployeeData, String> idColumn;
    @FXML
    private TableColumn<EmployeeData, String> nameColumn;
    @FXML
    private TableColumn<EmployeeData, String> departmentColumn;

    @FXML
    private Button addEntryBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button updateBtn;

    private String clickName;
    private String clickDepartment;

    //instantiate a model
    HomeModel homeModel = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.homeModel = new HomeModel();
        this.loadEmployeeData();        
    }

    //load data
    @FXML
    public void loadEmployeeData(){

        this.idColumn.setCellValueFactory( new PropertyValueFactory<EmployeeData, String>("id"));
        this.nameColumn.setCellValueFactory( new PropertyValueFactory<EmployeeData, String>("name"));
        this.departmentColumn.setCellValueFactory( new PropertyValueFactory<EmployeeData, String>("department"));

        this.employeeDataTableView.setItems(homeModel.getEmployees());
    }

    //add employee
    @FXML
    private void addEmployee(ActionEvent event){
        homeModel.addEmployee(this.name.getText(), this.department.getText());
        this.loadEmployeeData();
        this.clearFields(null);
    }

    //update employee
    @FXML 
    private void updateEmployee(ActionEvent event){
        homeModel.updateEmployee(this.name.getText(), this.department.getText(), clickName, clickDepartment);
        this.loadEmployeeData();
        this.clearFields(null);
    }
    
    //delete employee
    @FXML
    private void deleteEmployee(ActionEvent event){
        // homeModel.deleteEmployee(this.name.getText(), this.department.getText());
        homeModel.deleteEmployee(clickName, clickDepartment);
        this.loadEmployeeData();
        this.clearFields(null);
    }

    //click employee
    @FXML
    private void clickEmployee(MouseEvent event) {
        EmployeeData employee = employeeDataTableView.getSelectionModel().getSelectedItem();
        clickName = employee.nameProperty().get();
        clickDepartment = employee.departmentProperty().get();
        this.name.setText(clickName);
        this.department.setText(clickDepartment);
    }

    //clear fields
    @FXML
    private void clearFields(ActionEvent event){
        this.name.setText("");
        this.department.setText("");
    }

}
