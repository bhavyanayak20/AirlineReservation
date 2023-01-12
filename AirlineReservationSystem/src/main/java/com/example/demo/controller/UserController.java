/*
 * package com.example.demo.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.demo.entity.User; import
 * com.example.demo.service.UserService;
 * 
 * @RestController
 * 
 * @RequestMapping("/user") public class UserController {
 * 
 * @Autowired private UserService userService;
 * 
 * @PostMapping("/add") public ResponseEntity<Object> createUser(@RequestBody
 * User user) { try { return
 * ResponseEntity.ok().body(userService.addUser(user)); } catch (Exception e) {
 * return new ResponseEntity<>("User could not be added",
 * HttpStatus.INTERNAL_SERVER_ERROR); } }
 * 
 * @GetMapping("/findAllUser") public List<User> getUser() {
 * 
 * return userService.getAllUsers(); }
 * 
 * @GetMapping("listbyemail/{email}") public ResponseEntity<Object>
 * getUserByEmail(@PathVariable String email) { try { return
 * ResponseEntity.ok().body(userService.getUserByemail(email)); } catch
 * (Exception e) { return new ResponseEntity<>("User not found with email " +
 * email, HttpStatus.NOT_FOUND); } }
 * 
 * @PutMapping("/update/{id}") public ResponseEntity<Object>
 * updateUser(@PathVariable int id, @RequestBody User user) { try {
 * user.setId(id); return
 * ResponseEntity.ok().body(userService.updateUser(user)); } catch (Exception e)
 * { return new ResponseEntity<>("User not found with id" + id,
 * HttpStatus.NOT_FOUND); } }
 * 
 * @DeleteMapping("/delete/{id}") public ResponseEntity<Object>
 * deleteUser(@PathVariable int id) { try { userService.deleteUser(id); return
 * new ResponseEntity<>("Deleted", HttpStatus.OK); } catch (Exception e) {
 * return new ResponseEntity<>("User not found with id" + id,
 * HttpStatus.INTERNAL_SERVER_ERROR); } }
 * 
 * }
 */