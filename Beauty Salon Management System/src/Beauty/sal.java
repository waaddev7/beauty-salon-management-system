package Beauty;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;


public class sal extends JFrame implements ActionListener {
private	List<Customer>customer = new ArrayList();
private	List<Service> services = new ArrayList(); 
private	List<Appointment> appointments = new ArrayList(); 
private	Map<String, Double> membershipDiscounts = new HashMap(); 
private	Map<String, List<Appointment>> appointmentMap = new HashMap();
private	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 JButton addCus,editcus,deletecus;
     JButton viewCus,addSer;
     JButton viewSer,editSer,deleteSer ;
     JButton editAppo,deleteAppo;
     JButton viewAppo,loadf;
     JButton savap,savcu;
     JTextArea textArealo = new JTextArea();
     JButton[][]   appointmentButtons = new JButton[8][5]; 
     JLabel [] dateLabels = new JLabel[5];
     private BufferedWriter output;
	ObjectInputStream input;
	 public sal() {
		 textArealo.setEditable(false);
		 setTitle("Beauty Salon Management System");
		 JPanel panel1=new JPanel (new GridLayout(7,2));
		 JPanel panel2=new JPanel();
		 	addCus =new JButton("Add Customer");
	        viewCus = new JButton("View Customers");
	        editcus=new JButton("Edit Customer");
	        deletecus=new JButton("Delete Customer");
	        editSer=new JButton("Edit Service");
	        deleteSer=new JButton("Delete Service");
	        addSer= new JButton("Add Service");
	        viewSer = new JButton("View Services");
	        editAppo = new JButton("Edit Appointment");
	        viewAppo = new JButton("View Appointments");
	        deleteAppo=new JButton("Delete Appointment");
	        loadf = new JButton(" load file");
	        savap=new JButton("save Appointment");
	        savcu=new JButton("save Customer");
	        panel1.add(addCus);panel1.add(viewCus);
	        panel1.add( editcus);panel1.add(  deletecus);
	        panel1.add(addSer); panel1.add(viewSer);
	        panel1.add( editSer);panel1.add(  deleteSer);
	        panel1.add(editAppo); panel1.add(viewAppo);
	        panel1.add(deleteAppo);panel1.add(loadf);panel1.add(savap);panel1.add(savcu);
	       
	        JPanel appointmentPanel = new JPanel(new GridLayout(8, 5));
	     int z=9;
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 5; j++) { 
	            appointmentButtons[i][j] = new JButton(String.format("%02d:00", z));
	            appointmentButtons[i][j].setBackground(Color.GREEN);
	     
	            appointmentPanel.add(appointmentButtons[i][j]);
	                appointmentButtons[i][j].addActionListener(this);
	            } 
	           z++;
	            }
       
	        JPanel   datePanel = new JPanel(new GridLayout(1, 6));
	        JLabel time =new JLabel("Time       \t");
	        datePanel .add(time); 
	       
	        Date date1= new Date();
	        for (int i = 0; i < 5; i++) {
	        	Date date = new Date(date1.getTime() + (long) i * 24 * 60 * 60 * 1000); 
	            dateLabels[i] = new JLabel(dateFormat.format(date), SwingConstants.CENTER);
	            datePanel.add(dateLabels[i]);
	        }
	       add(datePanel, BorderLayout.NORTH);
	       add(appointmentPanel, BorderLayout.CENTER);
	       add(panel1,BorderLayout.WEST);
	       addCus.addActionListener(this);
	       addSer.addActionListener(this);
	       editcus.addActionListener(this);
	       deletecus.addActionListener(this);
	       editSer.addActionListener(this);
	       editAppo.addActionListener(this);
	       deleteSer.addActionListener(this);
	       deleteAppo.addActionListener(this);
	       viewCus.addActionListener(this);
	       viewSer.addActionListener(this);
	       loadf.addActionListener(this);
	       viewAppo.addActionListener(this);
	       savap.addActionListener(this);
	       savcu.addActionListener(this);
	            } 
//**************************************************************************************************************************************************************	
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == addCus) {
			  addCustomerDialog() ;
		  }
		  else if (e.getSource() == editcus) {
		 editCustomerDialog(selectCustomer()) ;
			 
		  }
		  else if (e.getSource() == editSer) {
				 editServiceDialog(selectService()) ;
					 
				  }
		  else if (e.getSource() == loadf) {
		  loadData();
				  }
		  else if (e.getSource() == editAppo) {
				 editAppointmentDialog(selectAppointment()) ;		 
				  }
		  else if (e.getSource() == savap) {
			  saveToFileappointment() ;		 
				  }
		  else if (e.getSource() == savcu) {
			  saveToFilecustomer() ;		 
				  }
		  else if (e.getSource() == deletecus) {
				 deleteCustomerDialog(selectCustomer()) ; 
				  }
		  else if (e.getSource() == deleteSer) {
				 deleteServiceDialog(selectService()) ;	 
				  }
		 
		  else if (e.getSource() == addSer) {
		        addServiceDialog();
		    }
		  else if (e.getSource() == viewCus) {
			  viewCustomersDialog();
		    }  else if (e.getSource() == viewSer) {
			  viewServicesDialog();
		    }
		    else if (e.getSource() == viewAppo) {
		    	viewAppointmentDialog();
			    }
		else if (e.getSource() == deleteAppo) {	 
		        	Appointment appointment1=selectAppointment();
		                for (Appointment appointment : appointments) { 
		                	String date = new SimpleDateFormat("yyyy-MM-dd").format(appointment.getDate());
		                	String date1= new SimpleDateFormat("yyyy-MM-dd").format(appointment1.getDate());
		                	if(date.equals(date1))
		                    deleteAppointmentDialog(appointment1, date);
		              
		            }
		        }
	  else 
		  for (int i = 0; i < 8; i++) {
		  for (int j = 0; j < 5; j++) { 
			   String date = dateFormat.format(new Date(new Date().getTime() + j * 24 * 60 * 60 * 1000));          	
             int hour = 9 + i;
			 if (e.getSource() == appointmentButtons[i][j]) {
				 String []options= {"Add Apointment", "EditorDelete"};
				 int choice = 	JOptionPane.showOptionDialog(null, "Would you like to add or editordelete the appointment?", "add EditorDelete", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		            if (choice == 0) {
                   addAppointmentDialog(date, hour);  }  
		            else  if (choice == 1) {
			 editOrDeleteAppointmentDialog(date,  hour);}
		        	
		 } 			
				  
 
 }}
}
//***********************************************************************************************************************************************
		 private void addCustomerDialog() {
		        JLabel l1 = new JLabel("Name:");
		        JLabel l2 = new JLabel("Phone Number:");
		        JLabel l3 = new JLabel("Membership Type:");		        
		        JTextField t1 = new JTextField(20); 
		        JTextField t2 = new JTextField(20); 		        
		        String[] membershipTypes = {"Silver", "Gold", "Platinum"};
		        JComboBox c1 = new JComboBox(membershipTypes);		        
		        JPanel panel = new JPanel(new GridLayout(0, 2));
		        panel.add(l1);
		        panel.add(t1);
		        panel.add(l2);
		        panel.add(t2);
		        panel.add(l3);
		        panel.add(c1);
		        int result = JOptionPane.showConfirmDialog(null, panel, "Add Customer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		        if (result == JOptionPane.OK_OPTION) {
		            String name = t1.getText();
		            String phoneNumber = t2.getText();	                
		            String membershipType = String.format("%s",c1.getSelectedItem());
		            if (!name.isEmpty() && !phoneNumber.isEmpty()) { 
		            	Customer customerr = new Customer(name, phoneNumber, membershipType);
		            customer.add(customerr);
		            JOptionPane.showMessageDialog(null, "Customer added ");	           
		                // يمكنك هنا إضافة دالة لحفظ العملاء في ملف أو قاعدة بيانات
		       saveData() ;
		            } 
		            else {
		                JOptionPane.showMessageDialog(null, "Invalid value Name and Phone Number. try again later	 ", "Error", JOptionPane.ERROR_MESSAGE);}
		        }
		    }
//**********************
		 private  void addServiceDialog() {
			 JLabel ll1=new JLabel("Name:");
			 JLabel ll2=new JLabel("Duration:");
			 JLabel ll3=new JLabel("Price:");
		        JTextField tt1 = new JTextField(20); 
		        JTextField tt2 = new JTextField(20); 		        
		        String[] dutbox = {"30 min", "1 hour", "1.5 hour","2 hour"};
		        JComboBox cc2 = new JComboBox(dutbox);		        
			 JPanel pa2 = new JPanel(new GridLayout(0, 2));
			 pa2.add(ll1); pa2.add(tt1);
			 pa2.add(ll2); pa2.add(cc2);
			 pa2.add(ll3); pa2.add(tt2);
			 int ree=JOptionPane.showConfirmDialog(null, pa2, "Add Service", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
if (ree==JOptionPane.OK_OPTION) {
	String names=tt1.getText();
	double price=Double.parseDouble(tt2.getText());
	String s2 = String.format("%s",cc2.getSelectedItem());
    if (!names.isEmpty() && price>0) { 
    	Service s1=new Service(names,s2,price);
    	services.add(s1);
    	JOptionPane.showMessageDialog(null, "Service added ");   
        // يمكنك هنا إضافة دالة لحفظ العملاء في ملف أو قاعدة بيانات
    saveData() ;
    } }
    else {
        JOptionPane.showMessageDialog(null, "Invalid value  Service Name and Price try again later", "Error2", JOptionPane.ERROR_MESSAGE);}
  }
//***********
		private Customer selectCustomer() {
			Customer arrcus[]=new Customer[customer.size()];
			int i=0;		
			for(Customer c:customer) {
				arrcus[i]=c;
				 i++;
			}
	   JComboBox cusbox=new JComboBox(arrcus);
	   int re= JOptionPane.showConfirmDialog(null,cusbox,"Select Customer",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	 if (re == JOptionPane.OK_OPTION) {
		    return (Customer) cusbox.getSelectedItem();
		}
			return null;
			
		}
//************
		private Service selectService() {	
			Service arrser[]=new Service[services.size()];
			int i=0;		
			for(Service c:services) {
				arrser[i]=c;
				 i++;
			}
			JComboBox serbox=new JComboBox(arrser);
	   		int re= JOptionPane.showConfirmDialog(null,serbox,"Select Service",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	   		if (re == JOptionPane.OK_OPTION) {
		     return(Service) serbox.getSelectedItem();
		    
		}
	return null;
		}
//*********	
		private Appointment selectAppointment() {
			 Appointment arrapp[]=new  Appointment[ appointments.size()];
			int i=0;		
			for( Appointment c:appointments) {
				arrapp[i]=c;
				 i++;
			}
			JComboBox serbox=new JComboBox(arrapp);
	   		int re= JOptionPane.showConfirmDialog(null,serbox,"Select Appointment ",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	   		if (re == JOptionPane.OK_OPTION) {
		     return( Appointment) serbox.getSelectedItem();
		    
		}
	return null;
		}
//**************		
		private void editCustomerDialog(Customer customer1) {
	    if (customer1 == null) {
			        JOptionPane.showMessageDialog(null, "No customer selected.");
			        return;
			    }
			    JTextField nameField = new JTextField(customer1.getName(), 20);
			    JTextField phoneField = new JTextField(customer1.getPhoneNumber(), 20);
			    String[] membershipOptions = {"Silver", "Gold", "Platinum"};
			    JComboBox membershipBox = new JComboBox(membershipOptions);
			    membershipBox.setSelectedItem(customer1.getMembershipType());

			    JPanel panel = new JPanel(new GridLayout(0, 1));
			    panel.add(new JLabel("Name:"));
			    panel.add(nameField);
			    panel.add(new JLabel("Phone Number:"));
			    panel.add(phoneField);
			    panel.add(new JLabel("Membership Type:"));
			    panel.add(membershipBox);
			    int result = JOptionPane.showConfirmDialog(null, panel, "Edit Customer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			    if (result == JOptionPane.OK_OPTION) {
			        customer1.setName(nameField.getText());
			        customer1.setPhoneNumber(phoneField.getText());
			        customer1.setMembershipType(String.format("%s", membershipBox.getSelectedItem()));
			        saveData() ;
			        
			    }
			}
//****************	
		private void editServiceDialog(Service ser1) {
		    if (ser1 == null) {
				        JOptionPane.showMessageDialog(null, "No Service selected.");
				        return;
				    }
				    JTextField name = new JTextField(ser1.getName(), 20);
				    JTextField price11= new JTextField(String.valueOf(ser1.getPrice()), 20);
				    String[] dutbox = {"30 min", "1 hour", "1.5 hour","2 hour"};
			        JComboBox cc2 = new JComboBox(dutbox);		
			        cc2 .setSelectedItem(ser1.getDuration());

				    JPanel panel = new JPanel(new GridLayout(0, 1));
				    panel.add(new JLabel("Name:"));
				    panel.add(name);
				    panel.add(new JLabel("Duration:"));
				    panel.add(cc2);
				    panel.add(new JLabel("Price:"));
				    panel.add(price11);
				    int result = JOptionPane.showConfirmDialog(null, panel, "Edit Service", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				    if (result == JOptionPane.OK_OPTION) {
				       ser1.setName(name.getText());
				       ser1.setDuration((String) cc2.getSelectedItem());
				    saveData() ; 
				    }
				}

		
//**********
		void deleteCustomerDialog(Customer customer2){
			 if (customer2 == null) {
			        JOptionPane.showMessageDialog(null, "No customer to delete ");
			        return;
			    }
			 else {
				 int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + customer2 + " and all related appointments?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			        if (confirm == JOptionPane.YES_OPTION) {
				        if (confirm == JOptionPane.YES_OPTION) {
		            customer.remove(customer2); 
		            List<Appointment> appointmentstoremove = new ArrayList<>();
		            for (Appointment appointment : appointments) {
		                if (appointment.getCustomer().equals(customer2)) {
		                    appointmentstoremove.add(appointment);
		                }
		            }
		            
		            for (Appointment appointment : appointmentstoremove) {		             
		                String dateKey = new SimpleDateFormat("yyyy-MM-dd").format(appointment.getDate());
		            deleteAppointmentDialog(appointment,dateKey); // حذف الموعد من الأزرار
		            }
		           saveData() ;
		            JOptionPane.showMessageDialog(null, "Customer deleted successfully."); 
		          
		            }}
				        else JOptionPane.showMessageDialog(null, "pls try again later");  }
			 }
//***********		
		void deleteServiceDialog(Service ser){
			 if (ser == null) {
			        JOptionPane.showMessageDialog(null, "No Service to delete ");
			        return;
			    }
			 else {
				 int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + ser + " and all related appointments?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			        if (confirm == JOptionPane.YES_OPTION) {
			  if (confirm == JOptionPane.YES_OPTION) {
		           services.remove(ser);
		            List<Appointment> appointmentstoremove = new ArrayList<>();
		            for (Appointment appointment : appointments) {
		                if (appointment.getService().equals(ser)) {
		                    appointmentstoremove.add(appointment);
		                }
		            }
		            
		            for (Appointment appointment : appointmentstoremove) {		             
		                String dateKey = new SimpleDateFormat("yyyy-MM-dd").format(appointment.getDate());
		                String hour = new SimpleDateFormat("HH").format(appointment.getDate());
		                List<Appointment> dateAppointments = appointmentMap.get(dateKey);
		                int h=Integer.parseInt(hour);
		               deleteAppointmentDialog(appointment,dateKey); // حذف الموعد من الأزرار
		            }
		          saveData() ;
		            JOptionPane.showMessageDialog(null, "Service deleted successfully.");
		            }        }
		        else JOptionPane.showMessageDialog(null, "pls try again later");  }
		}
//**********		
		private void viewCustomersDialog() {
			JTextArea textArea = new JTextArea();
	      	textArea.setEditable(false);
		StringBuilder allcus= new StringBuilder();
		if (customer.isEmpty()) {
	        textArea.setText("No customers to display.");
	    } else {
			for(Customer c:customer) {
		    String customerdet = String.format("Name: %s\tPhone Number: %s\tMembership Type: %s\n",
	                c.getName(), c.getPhoneNumber(), c.getMembershipType());
		  allcus.append(customerdet);
		    }
			String s=allcus.toString();
			textArea.setText(s);
			}
		    JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Customer Details", JOptionPane.PLAIN_MESSAGE);
		}
//************		
		private void viewAppointmentDialog() {
			JTextArea textArea = new JTextArea();
	      	textArea.setEditable(false);
		StringBuilder allapp= new StringBuilder();
		if (appointments.isEmpty()) {
	        textArea.setText("No appointments to display.");
	    } else { 
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm ");
			for(Appointment a:appointments) {
				String datess = dateFormat.format(a.getDate());
		    String appoindet = String.format("Customer Details: %s\n Service Details: %s\n :Date %s\n TotalPrice: %f\\n",
	                a.getCustomer(), a.getService(),datess ,a.getTotalPrice());
             allapp.append(appoindet);
		    }
			String s=allapp.toString();
			textArea.setText(s);
			}
		    JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Appointment Details", JOptionPane.PLAIN_MESSAGE);
		}
//*****************************************************
		private void viewServicesDialog() {
			JTextArea textArea2 = new JTextArea();
			textArea2.setEditable(false);
			StringBuilder allser= new StringBuilder();
			if (services.isEmpty()) {
		        textArea2.setText("No services to display.");
		    } else {
				for(Service ser:services) {
					
	String servicedet=String.format("NameSer : %s\tDuration: %s\tPrice: %f\n",ser.getName(),
			ser.getDuration(),ser.getPrice() );
			allser.append(servicedet);	
				}
				String s=allser.toString();
				textArea2.setText(s);
		} 
		JOptionPane.showMessageDialog(null, new JScrollPane(textArea2), "Service Details", JOptionPane.PLAIN_MESSAGE);

		}
//************************************
		private void addAppointmentDialog(String date, int hour) {
		    try {
		        //التاريخ والوقت  Date
		    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		         Date appointmentDate = dateFormat.parse(date + " " + hour + ":00:00");
		  
		        JLabel ll1 = new JLabel("Customer:");
		        JLabel ll2 = new JLabel("Service:");
		        JLabel ll3 = new JLabel("Date:");
		        JLabel ll33 = new JLabel(date);
		        JLabel ll4 = new JLabel("Time:");	        
		        JLabel ll44 = new JLabel(String.format("%02d",hour));
		        Service[] arrser = new Service[services.size()];
		        int i = 0;
		        for (Service c : services) {
		            arrser[i] = c;
		            i++;
		        }
		        JComboBox serbox = new JComboBox(arrser);
		        Customer[] arrcus = new Customer[customer.size()];
		        int j = 0;
		        for (Customer c : customer) {
		            arrcus[j] = c;
		            j++;
		        }
		        JComboBox cusbox = new JComboBox(arrcus);

		        JPanel pa2 = new JPanel(new GridLayout(0, 2));
		        pa2.add(ll1);
		        pa2.add(cusbox);
		        pa2.add(ll2);
		        pa2.add(serbox);
		        pa2.add(ll3);
		        pa2.add(ll33);
		        pa2.add(ll4);
		        pa2.add(ll44);

		        int ree = JOptionPane.showConfirmDialog(null, pa2, "Add Appointment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		        if (ree == JOptionPane.OK_OPTION) {
		            Customer selectedCustomer = (Customer) cusbox.getSelectedItem();
		            Service selectedService = (Service) serbox.getSelectedItem();

		            if (selectedCustomer == null) {
		                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to add a new customer?", "Confirm ADD new", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		                if (confirm == JOptionPane.YES_OPTION) {
		                    addCustomerDialog();
		                    // إعادة عرض شاشة البنل
		                    addAppointmentDialog(date, hour);		            
		                    return;
		                }
		            }

		            if (selectedService == null) {
		                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to add a new service?", "Confirm ADD new", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		                if (confirm == JOptionPane.YES_OPTION) {
		                    addServiceDialog();	                 
		                    // إعادة عرض شاشة البنل
		                    addAppointmentDialog(date, hour);
		                    return;
		                }
		            }
 
		            if (selectedCustomer != null && selectedService != null) {
		                // calua price
		                membershipDiscounts.put("Silver", 0.1);
		    			membershipDiscounts.put("Gold", 0.15);
		    			membershipDiscounts.put("Platinum", 0.2);
		    		    double discount = membershipDiscounts.get(selectedCustomer.getMembershipType());		    		  
		    		   double totalPrice = selectedService.getPrice() * (1 - discount);	
		    		   if (!appointmentMap.containsKey(date)) {
		                    appointmentMap.put(date, new ArrayList<>());
		                }
		    		   int count = 0;
		    		   for (Appointment appointment1 : appointmentMap.get(date)) {
		                    if ( appointment1.getDate().equals(appointmentDate)) {
		                        count++;
		                    }
		    		   }
		                if (count < 3) {
		        
		                    Appointment appointment = new Appointment(selectedCustomer, selectedService, appointmentDate, totalPrice);         
		                    appointments.add(appointment);
		                    count++;  
		                    appointmentMap.get(date).add(appointment);	                    
                              //date butt		
		                int columni = -1;
		                    for (int k = 0; k < 5; k++) {
		                        if (dateLabels[k].getText().equals(date)) {
		                            columni = k;
		                            break;
		                        }
		                    }
		                    if (columni != -1) {
		                        if (count == 1) {
		                            appointmentButtons[hour - 9][columni].setBackground(Color.PINK);
		                        } else if (count == 2) {
		                            appointmentButtons[hour - 9][columni].setBackground(Color.YELLOW);
		                        } else if (count == 3) {
		                            appointmentButtons[hour - 9][columni].setBackground(Color.RED);
		                        }
		                    }
		                    saveData();
		                    JOptionPane.showMessageDialog(null, "Appointment added successfully.");
		                } else {
		                    JOptionPane.showMessageDialog(null, "The selected time is not available.", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Customer or Service not selected.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    } catch (ParseException e) {
		        // التعامل مع تنسيق التاريخ أو الوقت غير الصحيح
		        JOptionPane.showMessageDialog(null, "Invalid date or time format.", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		}
		private void editOrDeleteAppointmentDialog(String date, int hour) {
		    // استخراج قائمة المواعيد للتاريخ المحدد
		    List<Appointment> dateAppointments = appointmentMap.get(date);
		    
		    if (dateAppointments == null || dateAppointments.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "No appointments available for the selected date and time.");
		        return;
		    }

		    // قائمة المواعيد في الساعة المحددة
		    List<Appointment> appointmentsAtHour = new ArrayList<>();
		    for (Appointment appointment : dateAppointments) {
		        String apphour = new SimpleDateFormat("HH").format(appointment.getDate());
		        int h = Integer.parseInt(apphour);
		        if (h == hour) {
		            appointmentsAtHour.add(appointment);
		        }
		    }

		    if (appointmentsAtHour.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "No appointments available for the selected date and time.");
		        return;
		    }
		    int result = JOptionPane.showConfirmDialog(null, "Appointment", "Select Appointment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		    if (result == JOptionPane.OK_OPTION) {
		        Appointment selectedAppointment = selectAppointment();
		        if (selectedAppointment != null) {
		            String[] options = {"Edit", "Delete"};
		            	 int choice = 	JOptionPane.showOptionDialog(null, "Would you like to edit or delete the appointment?", "Edit or Delete", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		            if (choice == 0) {
		                editAppointmentDialog(selectedAppointment);
		            } else if (choice == 1) {
		                deleteAppointmentDialog(selectedAppointment, date);
		            }
		        }
		    }
		}

//*********************************************************
   private void editAppointmentDialog(Appointment appointment) {
	    try {
	        JLabel ll1 = new JLabel("Customer:");
	        JLabel ll2 = new JLabel("Service:");
	        JLabel ll3 = new JLabel("Date:");
	        JLabel ll4 = new JLabel("Time:");

	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	        JLabel ll33 = new JLabel(dateFormat.format(appointment.getDate()));
	        JLabel ll44 = new JLabel(timeFormat.format(appointment.getDate()));

	        Service[] arrser = new Service[services.size()];
	        services.toArray(arrser);
	        JComboBox<Service> serbox = new JComboBox<>(arrser);
	        serbox.setSelectedItem(appointment.getService());
	        Customer[] arrcus = new Customer[customer.size()];
	        customer.toArray(arrcus);
	        JComboBox<Customer> cusbox = new JComboBox<>(arrcus);
	        cusbox.setSelectedItem(appointment.getCustomer());

	        JPanel pa2 = new JPanel(new GridLayout(0, 2));
	        pa2.add(ll1);
	        pa2.add(cusbox);
	        pa2.add(ll2);
	        pa2.add(serbox);
	        pa2.add(ll3);
	        pa2.add(ll33);
	        pa2.add(ll4);
	        pa2.add(ll44);

	        int result = JOptionPane.showConfirmDialog(null, pa2, "Edit Appointment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	            Customer selectedCustomer = (Customer) cusbox.getSelectedItem();
	            Service selectedService = (Service) serbox.getSelectedItem();

	            if (selectedCustomer != null && selectedService != null) {
	                double discount = membershipDiscounts.get(selectedCustomer.getMembershipType());
	                double totalPrice = selectedService.getPrice() * (1 - discount);

	                appointment.setCustomer(selectedCustomer);
	                appointment.setService(selectedService);
	                appointment.setTotalPrice(totalPrice);

	                JOptionPane.showMessageDialog(null, "Appointment updated successfully.");
	            } else {
	                JOptionPane.showMessageDialog(null, "Customer or Service not selected.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "An error occurred while updating the appointment.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
//**********************************************************************************
   private void deleteAppointmentDialog(Appointment appointment, String date) {
	    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the appointment?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	    if (confirm == JOptionPane.YES_OPTION) {

	      
	        // استخراج تاريخ ووقت الموعد بصيغة yyyy-MM-dd و HH
	       // String dateKey = new SimpleDateFormat("yyyy-MM-dd").format(appointment.getDate());
	        String hour = new SimpleDateFormat("HH").format(appointment.getDate());
	        int h = Integer.parseInt(hour);

	        // حذف الموعد من القوائم والخريطة
	        appointments.remove(appointment);
	        List<Appointment> dateAppointments = appointmentMap.get(date);
	        if (dateAppointments != null) {
	            dateAppointments.remove(appointment);
	            if (dateAppointments.isEmpty()) {
	                appointmentMap.remove(date);
	            }
	        }

	        // تحديث لون الزر بناءً على عدد المواعيد المتبقية
	        int columni = -1;
	        for (int k = 0; k < 5; k++) {
	            if (dateLabels[k].getText().equals(date)) {
	                columni = k;
	                break;
	            }
	        }

	        if (columni != -1) {
	            Color currentColor = appointmentButtons[h - 9][columni].getBackground();

	            // تحديث لون الزر بناءً على اللون الحالي
	            if (currentColor.equals(Color.RED)) {
	                appointmentButtons[h - 9][columni].setBackground(Color.YELLOW);
	            } else if (currentColor.equals(Color.YELLOW)) {
	                appointmentButtons[h - 9][columni].setBackground(Color.PINK);
	            } else if (currentColor.equals(Color.PINK)) {
	                appointmentButtons[h - 9][columni].setBackground(Color.GREEN);
	            } 
	        }

	        JOptionPane.showMessageDialog(null, "Appointment deleted successfully.");
	    }
	}	File file =new File("salon.txt");
		private void saveData() {
	       try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
	            oos.writeObject(customer);
	            oos.writeObject(services);
	            oos.writeObject(appointments);
	            oos.writeObject(appointmentMap);
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
		   private void loadData() {
		        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
		        	List<Customer> loadedCustomers = (List<Customer>) ois.readObject();
		            List<Service> loadedServices = (List<Service>) ois.readObject();
		            List<Appointment> loadedAppointments = (List<Appointment>) ois.readObject();
		         //   Map<String, List<Appointment>> loadedAppointmentMap = (Map<String, List<Appointment>>) ois.readObject();
		            
		            // إضافة البيانات المحملة إلى البيانات الحالية بدلاً من الاستبدال
		            if (loadedCustomers != null) {
		                customer.addAll(loadedCustomers);
		            }
		            if (loadedServices != null) {
		                services.addAll(loadedServices);
		            }
		            if (loadedAppointments != null) {
		                appointments.addAll(loadedAppointments);
		            }
		            
		            // عرض البيانات في واجهة المستخدم
		            displayData();
		        }catch (IOException | ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		    }
		    private void displayData() {
		        textArealo.setText(""); // Clear existing text
		        if (customer != null) {
		            textArealo.append("Customers:\n");
		            for (Customer c : customer) {
		                textArealo.append(c.toString() + "\n");
		            }
		            textArealo.append("\n");
		        }

		        if (services != null) {
		            textArealo.append("Services:\n");
		            for (Service s : services) {
		                textArealo.append(s.toString() + "\n");
		            }
		            textArealo.append("\n");
		        }

		        if (appointments != null) {
		            textArealo.append("Appointments:\n");
		            for (Appointment a : appointments) {
		                textArealo.append(a.toString() + "\n");
		            }
		            textArealo.append("\n");
		            JOptionPane.showMessageDialog(null, new JScrollPane(textArealo), " Details", JOptionPane.PLAIN_MESSAGE);
		        }
		        }
		
		public void openFile()
		{ JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setCurrentDirectory(new File("."));
		int result = fc.showSaveDialog(null);
		if(result== JFileChooser.CANCEL_OPTION)
		return;
		File f = fc.getSelectedFile();
		try // open file
		{
			output = new BufferedWriter(new FileWriter(f));
		//output = new ObjectOutputStream(new FileOutputStream(f));
		} // end try
		catch ( IOException ioException )
		{
		System.err.println( "Error opening file." );
		} // end catch
		} // end method openFile
	
		   private void saveToFileappointment()
		{ 
		openFile();
		
		
		if (appointments == null || appointments.isEmpty()) {
	        System.err.println("No appointments to save.");
	        return;
	    }
	    
	    
	    if (output != null) {
	       
		try
		{ 
			for (Appointment record : appointments) {
	            output.write(record.toString()); // تحويل السجل إلى سلسلة نصية
	            output.newLine(); // إضافة سطر جديد لكل سجل
	        }
		} // end try
		catch ( IOException ioException )
		{
		System.err.println( "Error writing to file." );
		return;
		}// end catch
		
	    }
		closeFile() ;
		} // end method saveToFile
		// close file
		   private void saveToFilecustomer()
			{ 
			openFile();
			
			
			if (customer == null || customer.isEmpty()) {
		        System.err.println("No customer to save.");
		        return;
		    }
		    
		    
		    if (output != null) {
		       
			try
			{ 
				for (Customer record : customer) {
		            output.write(record.toString()); // تحويل السجل إلى سلسلة نصية
		            output.newLine(); // إضافة سطر جديد لكل سجل
		        }
			} // end try
			catch ( IOException ioException )
			{
			System.err.println( "Error writing to file." );
			return;
			}// end catch
			
		    }
			closeFile() ;
			} 
		public void closeFile() 
		{
		try // close file
		{
		if ( output != null )
		output.close();
		} // end try
		catch ( IOException ioException )
		{
		System.err.println( "Error closing file." );
		System.exit( 1 );
		} // end catch
		} // end method closeFile
		
		
	public static void main (String []args) {

		sal fs=new sal ();
	fs.setSize(350,100);
	fs.setVisible(true);
	fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}}

	
