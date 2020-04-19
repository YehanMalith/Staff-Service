package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Staff;
import service.StaffService;

@Path("/Staff")
public class StaffResources {

	Staff staff = new Staff();
	StaffService staffService = new StaffService();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readStaff() {
		return staffService.readStaff();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertStaff(@FormParam("staffNic") String staffNic, @FormParam("staffName") String staffName,
			@FormParam("staffMobileno") String staffMobileno, @FormParam("staffEmail") String staffEmail,
			@FormParam("staffName") String staffGender, @FormParam("staffName") String staffSpecialize) {
		String output = staffService.insertStaff(staffNic, staffName, staffMobileno, staffEmail, staffGender,
				staffSpecialize);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateStaff(String staffData) {
		// Convert the input string to a JSON object
		JsonObject staffObject = new JsonParser().parse(staffData).getAsJsonObject();
		// Read the values from the JSON object
		String staffID = staffObject.get("staffID").getAsString();
		String staffNic = staffObject.get("staffNic").getAsString();
		String staffName = staffObject.get("staffName").getAsString();
		String staffMobileno = staffObject.get("staffMobileno").getAsString();
		String staffEmail = staffObject.get("staffEmail").getAsString();
		String staffGender = staffObject.get("staffGender").getAsString();
		String staffSpecialize = staffObject.get("staffSpecialize").getAsString();
		String output = staffService.updateStaff(staffID, staffNic, staffName, staffMobileno, staffEmail, staffGender,
				staffSpecialize);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteStaff(String staffData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(staffData, "", Parser.xmlParser());

		// Read the value from the element <staffID>
		String staffID = doc.select("staffID").text();
		String output = staffService.deleteStaff(staffID);
		return output;
	}

}
