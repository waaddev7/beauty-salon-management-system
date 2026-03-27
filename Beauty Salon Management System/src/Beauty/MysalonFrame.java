package Beauty;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
/*public class MysalonFrame extends JFrame implements ActionListener {
	List<Customer>customer = new ArrayList();
	List<Service> services = new ArrayList(); 
	List<Appointment> appointments = new ArrayList(); 
	Map<String, Double> membershipDiscounts = new HashMap(); 
	Map<String, List<Appointment>> appointmentMap = new HashMap();
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 JButton addCus;
     JButton viewCus,addSer;
     JButton viewSer ;
     JButton addAppo;
     JButton viewAppo; 
     JLabel time,date;
	 public  MysalonFrame () {
		 setTitle("Beauty Salon Management System");
		 
		 
		 JPanel panel1=new JPanel (new GridLayout(3,2));
		 JPanel panel2=new JPanel();
		 	addCus =new JButton("Add Customer");
	        viewCus = new JButton("View Customers");
	        addSer= new JButton("Add Service");
	        viewSer = new JButton("View Services");
	        addAppo = new JButton("Add Appointment");
	        viewAppo = new JButton("View Appointments");
	        panel1.add(addCus);panel1.add(viewCus);
	        panel1.add(addSer); panel1.add(viewSer);
	        panel1.add(addAppo); panel1.add(viewAppo);
	        add(panel1,BorderLayout.WEST);
	/*      Date d;
	     time =new JLabel("Time ");
	    date =new JLabel("Date (yyyy-MM-dd):");
	   panel2.add(time); panel2.add(date);
	   add(panel2,BorderLayout.CENTER);
	        JPanel appointmentPanel = new JPanel(new GridLayout(8, 5));
	        JButton[][]   appointmentButtons = new JButton[8][8];
int z=9;
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 5; j++) { 
	            appointmentButtons[i][0] = new JButton(String.format("%02d:00", z));
	            appointmentButtons[i][0].setBackground(Color.GREEN);
	           // appointmentButtons[i][0].addActionListener(this::handleAppointmentButton);
	            appointmentPanel.add(appointmentButtons[i][0]);
	           
	            } 
	            z++;
	            }

	        add(appointmentPanel, BorderLayout.CENTER);
	        JPanel   datePanel = new JPanel(new GridLayout(1, 5));
	        JLabel [] dateLabels = new JLabel[5];

	        Date date 1= new Date();
	        for (int i = 0; i < 5; i++) {
	            Date date = new Date() // Adding days in milliseconds
	            dateLabels[i] = new JLabel(dateFormat.format(date), SwingConstants.CENTER);
	            datePanel.add(dateLabels[i]);
	        }

	        selectedDate = dateFormat.format(date);

	        mainPanel.add(datePanel, BorderLayout.NORTH);
	            } 
	
	private void handleAppointmentButton(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String time = button.getText();
        String date = JOptionPane.showInputDialog("Enter date (yyyy-MM-dd):");

        if (date != null && !date.isEmpty()) {
            try {
                String dateTime = date + " " + time + ":00";
                Date appointmentDate = (Date) dateFormat.parse(dateTime);*/
               // Customer customer = selectCustomer();
               // Service service = selectService();
                
          /*      Object service;
				if (customer != null && service != null) {
                    double totalPrice = service.getPrice() * (1 - getMembershipDiscount(customer.getMembershipType()));
                    Appointment appointment = new Appointment(customer, service, appointmentDate, totalPrice);
                    appointments.add(appointment);
                  //  saveAppointments();
                  //  updateAppointmentButtons();
                    }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }}
        }*/
	/*public void actionPerformed(ActionEvent e) {
		if (e.getSource()==addCus) {
			JLabel l1,l2,l3;
			l1=new JLabel("Name:	");
			l2=new JLabel("Phone Number:	");
			l3=new JLabel("Membership Type:	");
			JTextField t1 ,t2;
			t1=new JTextField(20);
			t2=new JTextField(20);
			final String [] memship = {"Silver","Gold","Plantinum"};
			JComboBox c1=new JComboBox(memship);
			Customer c =new Customer();
			if (e.getSource()==t1) {		
				c.setName(t1.getText());
			}
			else if (e.getSource()==t2) {		
				c.setPhoneNumber(t2.getText());
			}
			else if (e.getSource()==c1) {		
				c.setMembershipType(c1.getActionCommand());
			}
			customer.add(c);
  
		}
		
	}
	
	 

	public static void main(String []args) {

		MysalonFrame f=new MysalonFrame  ();
	f.setSize(350,100);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
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
     JButton addAppo;
     JButton viewAppo;
     JButton[][]   appointmentButtons = new JButton[8][5]; 
     JLabel [] dateLabels = new JLabel[5];

	 public sal() {
		 setTitle("Beauty Salon Management System");
		 JPanel panel1=new JPanel (new GridLayout(5,2));
		 JPanel panel2=new JPanel();
		 	addCus =new JButton("Add Customer");
	        viewCus = new JButton("View Customers");
	        editcus=new JButton("Edit Customer");
	        deletecus=new JButton("Delete Customer");
	        editSer=new JButton("Edit Service");
	        deleteSer=new JButton("Delete Service");
	        addSer= new JButton("Add Service");
	        viewSer = new JButton("View Services");
	        addAppo = new JButton("Add Appointment");
	        viewAppo = new JButton("View Appointments");
	        panel1.add(addCus);panel1.add(viewCus);
	        panel1.add( editcus);panel1.add(  deletecus);
	        panel1.add(addSer); panel1.add(viewSer);
	        panel1.add( editSer);panel1.add(  deleteSer);
	        panel1.add(addAppo); panel1.add(viewAppo);
	       
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
	       addAppo.addActionListener(this);
	       addSer.addActionListener(this);
	       editcus.addActionListener(this);
	       deletecus.addActionListener(this);
	       editSer.addActionListener(this);
	       deleteSer.addActionListener(this);
	       viewCus.addActionListener(this);
	       viewSer.addActionListener(this);
	            } 
	
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
		 
	  else 
		  for (int i = 0; i < 8; i++) {
		  for (int j = 0; j < 5; j++) { 
			 if (e.getSource() == appointmentButtons[i][j]) {
          	 String date = dateFormat.format(new Date(new Date().getTime() + j * 24 * 60 * 60 * 1000));
           	
             int hour = 9 + i;
           //  if () {
             addAppointmentDialog(date, hour);//}
		  }}}
	 }
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
    } 
    else {
        JOptionPane.showMessageDialog(null, "Invalid value  Service Name and Price try again later", "Error2", JOptionPane.ERROR_MESSAGE);}
}  }
 
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
		   //********************************
		     return(Service) serbox.getSelectedItem();
		    
		}
	return null;
		}
		
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
			        // Save the updated customer list to the file
			    }
			}
		
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
				       saveData() ; // Save the updated customer list to the file
				    }
				} 
		void deleteCustomerDialog(Customer customer2){
			 if (customer2 == null) {
			        JOptionPane.showMessageDialog(null, "No customer to delete ");
			        return;
			    }
			 else {
  int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + customer2 +
		  "?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				        if (confirm == JOptionPane.YES_OPTION) {
		            customer.remove(customer2); 
		            saveData() ;
		            JOptionPane.showMessageDialog(null, "Customer deleted successfully."); 
		          
		            }
				        else JOptionPane.showMessageDialog(null, "pls try again later");  }}
		void deleteServiceDialog(Service ser){
			 if (ser == null) {
			        JOptionPane.showMessageDialog(null, "No Service to delete ");
			        return;
			    }
			 else {
				 int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + ser +
						  "?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			  if (confirm == JOptionPane.YES_OPTION) {
		           services.remove(ser);
		           saveData() ;
		            JOptionPane.showMessageDialog(null, "Service deleted successfully.");
		            }    
		        else JOptionPane.showMessageDialog(null, "pls try again later");  }
		}
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
		private void addAppointmentDialog(String date, int hour) {
		    try {
		        // جمع التاريخ والوقت في سلسلة نصية واحدة وتحليلها لإنشاء كائن Date
		        Date appointmentDate = dateFormat.parse(date + " " + hour + ":00:00");

		        // إعداد المكونات للوحة الإدخال
		        JLabel ll1 = new JLabel("Customer:");
		        JLabel ll2 = new JLabel("Service:");
		        JLabel ll3 = new JLabel("Date:");
		        JLabel ll33 = new JLabel(date);
		        JLabel ll4 = new JLabel("Time:");
		        JLabel ll44 = new JLabel(Integer.toString(hour));

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
		                // حساب السعر الإجمالي، مع تطبيق الخصم بناءً على نوع العضوية إذا لزم الأمر
		                double totalPrice = calculateTotalPrice(selectedCustomer, selectedService);

		                // تحقق من توفر الموعد الحالي
		              if (!appointmentMap.containsKey(date)) {
		                    appointmentMap.put(date, new ArrayList<>());
		                }
		                
		                int count = 0;
		                for (Appointment appointment : appointmentMap.get(date)) {
		                    if (appointment.getDate().equals(appointmentDate)) {
		                        count++;
		                    }
		                } 
		                if (count < 3) {
		                    // إنشاء كائن موعد جديد وإضافته إلى القائمة
		                    Appointment appointment = new Appointment(selectedCustomer, selectedService, appointmentDate, totalPrice);
		             
		                    // الحصول على عمود التاريخ في شبكة الأزرار
		                   
		                    appointments.add(appointment);
		                    appointmentMap.get(date).add(appointment);
                              count++;
		                    int columni = -1;
		                    for (int k = 0; k < 5; k++) {
		                        if (dateLabels[k].getText().equals(date)) {
		                            columni = k;
		                            break;
		                        }
		                    }

		                    if (columni != -1) {
		                        // تحديث لون الزر بناءً على عدد الزبائن
		                        if (count == 1) {
		                            appointmentButtons[hour - 9][columni].setBackground(Color.PINK);
		                        } else if (count == 2) {
		                            appointmentButtons[hour - 9][columni].setBackground(Color.YELLOW);
		                        } else if (count == 3) {
		                            appointmentButtons[hour - 9][columni].setBackground(Color.RED);
		                        }
		                    }

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
		// دالة مساعدة لحساب السعر الإجمالي مع الخصم على العضوية
		private double calculateTotalPrice(Customer customer, Service service) {
			membershipDiscounts.put("Silver", 0.1);
			membershipDiscounts.put("Gold", 0.15);
			membershipDiscounts.put("Platinum", 0.2);
		    double discount = membershipDiscounts.get(customer.getMembershipType());
		    return service.getPrice() * (1 - discount);
		}
		private void saveData() {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("salon_data.ser"))) {
	            oos.writeObject(customer);
	            oos.writeObject(services);
	            oos.writeObject(appointments);
	            oos.writeObject(appointmentMap);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private void loadData() {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("salon_data.ser"))) {
	            customer = (List<Customer>) ois.readObject();
	            services = (List<Service>) ois.readObject();
	            appointments = (List<Appointment>) ois.readObject();
	            appointmentMap = (Map<String, List<Appointment>>) ois.readObject();
	            for (Appointment appointment : appointments) {
	               // updateButtonColor(appointment.getDate(), appointment.getTotalPrice());
	            }
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	public static void main (String []args) {

		sal fs=new sal ();
	fs.setSize(350,100);
	fs.setVisible(true);
	fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}}
*/
