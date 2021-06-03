package com.example.demo.Admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Product;
import com.example.demo.Model.Roles;
import com.example.demo.Model.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Security.Payload.Request.SignupAdminRequest;
import com.example.demo.Security.Payload.Response.MessageResponse;
import com.example.demo.Service.FileStorageService;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.RoleService;
import com.example.demo.ServiceImp.UserServiceImp;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class AdminController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserServiceImp userService;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private RoleService roleService; 
	
	@Autowired
	private PasswordEncoder passwordEncode;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/employees")
	public List<User> getAllEmployees(){
		String tenVaiTro="ROLE_EMPLOYEE";
		Set<Roles> role= new HashSet<>();
		role.add(roleService.findByNameRoles(tenVaiTro));
		int page=1;
		Page<User> pageResult=userService.getUserByRoles(role, page);
		return pageResult.toList();
	}
	
	@PostMapping("/employees")
	public ResponseEntity<?> CreateEmployee(@RequestBody SignupAdminRequest user) {
		User userRegister=userService.findByEmail(user.getEmail());
		if(userRegister !=null) {
			String tenVaiTro="ROLE_EMPLOYEE";
			Set<Roles> role=userRegister.getRoles();
			role.add(roleService.findByNameRoles(tenVaiTro));
			userRegister.setRoles(role);
			userRegister.setActived(true);
			userService.saveAccount(userRegister);
		}
		else if(userRegister == null) {
			userService.RegisterAccountAdmin(user);
		}
		return ResponseEntity.ok(new MessageResponse("Registed Account Admin"));
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<User> getEmployeeById(@PathVariable Long id) {
		User employee = userRepo.findByUserid(id);
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable Long id, @RequestBody SignupAdminRequest employeeDetails){
		User employee = userRepo.findByUserid(id);
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setSdt(employeeDetails.getSdt());
		User updatedEmployee = userService.saveAccount(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		User employee = userRepo.findByUserid(id);
		
		userRepo.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
