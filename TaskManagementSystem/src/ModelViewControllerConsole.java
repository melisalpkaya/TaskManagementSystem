import java.util.*;


public class ModelViewControllerConsole {

	public static void main(String[] args) throws Exception {
		// Connect to database
		connectToDatabase();

		
		// Model View Controller (MVC)
		// Router knows all the controllers
		Map<String, Controller> router = new HashMap<>();
		router.put("Login", new Controller(new LoginView(), new NopModel()));
		router.put("Employee", new Controller(new EmployeeView(), new EmployeeModel()));
		router.put("ChiefEngineer", new Controller(new ChiefEngineerMenuView(), new NopModel()));
		router.put("Engineer", new Controller(new EngineerMenuView(), new NopModel()));
		router.put("Ceo", new Controller(new CeoMenuView(), new NopModel()));
		router.put("Task", new Controller(new TaskView(), new TaskModel()));
		router.put("SubTask", new Controller(new SubTaskView(), new SubTaskModel()));
		router.put("WorksOn", new Controller(new WorksOnView(), new WorksOnModel()));
		router.put("AttendBy", new Controller(new AttendByView(), new AttendByModel()));




		ViewData viewData = new ViewData("Login", "");
		do {
			// Model, View, and Controller
			Controller controller = router.get(viewData.functionName);
			ModelData modelData = controller.executeModel(viewData);
			viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);
			
			System.out.println();
			//System.out.println("-------------------------------------------------");
			//System.out.println();
		}
		while (viewData.functionName != null);
		
		System.out.println();
		System.out.println();
		System.out.println("Program is ended...");


		// Disconnect from database
		disconnectFromDatabase();
	}

	
	public static void connectToDatabase() {
		DatabaseUtilities.host = "localhost:50674";
		DatabaseUtilities.databaseName = "TaskManagementSystem";
		
		try {
			DatabaseUtilities.getConnection();
		}
		catch(Exception e) {
			System.out.println("Exception occured : " + e);
			return;
		}		
	}
	
	public static void disconnectFromDatabase() {
		try {
			DatabaseUtilities.disconnect();
		}
		catch(Exception e) {
			System.out.println("Error disconnecting from database : " + e);
			return;
		}		
	}
	
}
