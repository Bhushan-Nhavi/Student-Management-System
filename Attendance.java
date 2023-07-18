package project.java;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Attendance extends JFrame{

	int roll,ba;
	private String s9,sname;
	String string1;
	String name;
	 JComboBox jc;
	ResultSet rs;
	Connection con;
	PreparedStatement ps;
	JFrame j,j1,j2,j3,j4,j5,j6;
	JPasswordField p1,p2,p3,p4,p5;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l11,l12,l13,l14;
	JButton b1,b2,b3,b4, b5, b6 ,b7, b8, b9, b10, b11, b12, b13,b14,b15;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JRadioButton rb1,rb2, rb3, rb4,rb5,rb6;
	Attendance(){
		l1=new JLabel("Student Management System");
		l1.setBounds(150,50,200,60);
		b1=new JButton("Admin");
		b1.setBounds(150,150,150,50);
		b2=new JButton("Teacher");
		b2.setBounds(150,240,150,50);
		b3=new JButton("Student");
		b3.setBounds(150,330,150,50);
		b4=new JButton("Parent");
		b4.setBounds(150,420,150,50);
		add(l1);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 j=new JFrame("Admin Panel");
				l4=new JLabel("Admin Area");
				l4.setBounds(150,50,190,70);
				l2=new JLabel("Admin Name");
				l2.setBounds(30,150,140,20);
				t1=new JTextField();
				t1.setBounds(130,150,120,20);
				l3=new JLabel("Password");
				l3.setBounds(30,180,90,20);
				p1=new JPasswordField();
				p1.setBounds(130,180,80,20);
				b5=new JButton("Login");
				b5.setBounds(160,240,150,20);
				b6=new JButton("Cancel");
				b6.setBounds(320,240,120,20);
				j.add(l3);
				j.add(l2);
				j.add(l4);
				j.add(t1);
				j.add(p1);
				j.add(b5);
				j.add(b6);
				j.setLayout(null);
				j.setSize(600,600);
				j.setVisible(true);
				b5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String s="Bhushan Nhavi";
						String s1="101";
						String s2=t1.getText();
						String s3=p1.getText();
						if(s.equals(s2) && s1.equals(s3))
						{
							j.dispose();
						    j1=new JFrame("Admin Panel");
						    l5= new JLabel("Select  One");
							l5.setBounds(50,50,150,30);
							rb1=new JRadioButton("Student");
							rb1.setBounds(80,100,200,20);
							rb2=new JRadioButton("Teacher");
							rb2.setBounds(80,130,200,20);
							b7=new JButton("Select");
							b7.setBounds(80,150,80,20);
							ButtonGroup bg=new ButtonGroup();
							bg.add(rb1);
							bg.add(rb2);			
							j1.add(l5);
							j1.add(rb1);
							j1.add(rb2);
							j1.add(b7);
							j1.setSize(600,600);
							j1.setLayout(null);
							j1.setVisible(true);
						    b7.addActionListener(new ActionListener() {
								
								    public void actionPerformed(ActionEvent e) {
								        
								    	if(rb1.isSelected()){
								    		Studd();
								    		}
								    	else if(rb2.isSelected()) {
								    		Teacherd();
								    	}
								    		
								    	
								        
								    }
								});
							
						}
						else {
							JOptionPane.showMessageDialog(j, "Invalid User id or Password");
						}
						
					}
					
				});
			}
			
		});
		
//		Teacher Button Coding
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 j=new JFrame("Teacher Panel");
					l4=new JLabel("Teacher Work Area");
					l4.setBounds(150,50,300,70);
					l2=new JLabel(" Name");
					l2.setBounds(30,150,140,20);
					t1=new JTextField();
					t1.setBounds(130,150,120,20);
					l3=new JLabel("Password");
					l3.setBounds(30,180,90,20);
					p1=new JPasswordField();
					p1.setBounds(130,180,80,20);
					b5=new JButton("Login");
					b5.setBounds(160,240,150,20);
					b6=new JButton("Cancel");
					b6.setBounds(320,240,120,20);
					j.add(l3);
					j.add(l2);
					j.add(l4);
					j.add(t1);
					j.add(p1);
					j.add(b5);
					j.add(b6);
					j.setLayout(null);
					j.setSize(600,600);
					j.setVisible(true);
					b5.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							String s="Bhushan Nhavi";
							String s1="103";
							String s2=t1.getText();
							String s3=p1.getText();
							if(s.equals(s2) && s1.equals(s3)) {
								StudTeach();
							}
							else {
								JOptionPane.showMessageDialog(j, "Invalid User id or Password");
							}
							
						}
						
					});
				
			}
			
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				j=new JFrame("Student Check");
				l1=new JLabel("Enter the Roll_no");
				l1.setBounds(30,30,150,20);
				t1=new JTextField();
				t1.setBounds(170,30,150,20);
				l3=new JLabel("Batch");
				l3.setBounds(30,90,150,20);
				t3=new JTextField();
				t3.setBounds(170,90,150,20);
				b5=new JButton("Submit");
				b5.setBounds(170,150,90,40);
				j.add(l1);
				j.add(t1);
				j.add(l3);
				j.add(t3);
				j.add(b5);
				j.setLayout(null);
				j.setSize(600,600);
				j.setVisible(true);
				
				b5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						roll=Integer.parseInt(t1.getText());
						ba=Integer.parseInt(t3.getText());
						if(ba==1) {
							StudDis1();
						}else if(ba==2) {
							StudDis2();
						}
					}
					
				});
				
				
			}
			
			
			
		});
		
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				j=new JFrame("Parent Check");
				l1=new JLabel("Enter the Roll_no");
				l1.setBounds(30,30,150,20);
				t1=new JTextField();
				t1.setBounds(170,30,150,20);
				l3=new JLabel("Batch");
				l3.setBounds(30,90,150,20);
				t3=new JTextField();
				t3.setBounds(170,90,150,20);
				b5=new JButton("Submit");
				b5.setBounds(170,150,90,40);
				j.add(l1);
				j.add(t1);
				j.add(l3);
				j.add(t3);
				j.add(b5);
				j.setLayout(null);
				j.setSize(600,600);
				j.setVisible(true);
				b5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						roll=Integer.parseInt(t1.getText());
						ba=Integer.parseInt(t3.getText());
						if(ba==1) {
							StudDis1();
						}else if(ba==2) {
							StudDis2();
						}
					}
					
				});
			}
			
		});
		
		
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		
	}
	
	
	void StudDis1() {
		j1=new JFrame("Attendance Display");
		JTable jTable=new JTable();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
			if(con!=null) {
				System.out.println("Connection Established");
			}
			else {
				System.out.println("Connection Failed");
			}
			ps=con.prepareStatement("Select * from attendstud1 Where Roll_no =" + roll);
			rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int n=rsmd.getColumnCount();
			 Vector<String> columns = new Vector<>();
		        for (int i = 1; i <= n; i++) {
		            columns.add(rsmd.getColumnName(i));
		        }
		        DefaultTableModel dtm = new DefaultTableModel(columns, 0);
		        while (rs.next()) {
		            Vector<String> rowData = new Vector<>();
		            for (int i = 1; i <= n; i++) {
		                rowData.add(rs.getString(i));
		            }
		            dtm.addRow(rowData);
		        }

		        jTable.setModel(dtm);
		} catch (ClassNotFoundException q) {
			System.out.println(q);
			q.printStackTrace();
		} catch (SQLException o) {
			o.printStackTrace();
			System.out.println(o);
		}
		 JScrollPane scrollPane = new JScrollPane(jTable);
		    scrollPane.setBounds(50, 50, 500, 400);

		   j1.add(scrollPane);
		   j1.setSize(600,600);
		   j1.setLayout(null);
		   j1.setVisible(true);
	}
	
	
	void StudDis2() {
		j1=new JFrame("Attendance Display");
		JTable jTable=new JTable();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
			if(con!=null) {
				System.out.println("Connection Established");
			}
			else {
				System.out.println("Connection Failed");
			}
			ps=con.prepareStatement("Select * from attendstud2 Where Roll_no =" + roll);
			rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int n=rsmd.getColumnCount();
			 Vector<String> columns = new Vector<>();
		        for (int i = 1; i <= n; i++) {
		            columns.add(rsmd.getColumnName(i));
		        }
		        DefaultTableModel dtm = new DefaultTableModel(columns, 0);
		        while (rs.next()) {
		            Vector<String> rowData = new Vector<>();
		            for (int i = 1; i <= n; i++) {
		                rowData.add(rs.getString(i));
		            }
		            dtm.addRow(rowData);
		        }

		        jTable.setModel(dtm);
		} catch (ClassNotFoundException q) {
			System.out.println(q);
			q.printStackTrace();
		} catch (SQLException o) {
			o.printStackTrace();
			System.out.println(o);
		}
		 JScrollPane scrollPane = new JScrollPane(jTable);
		    scrollPane.setBounds(50, 50, 500, 400);

		   j1.add(scrollPane);
		   j1.setSize(600,600);
		   j1.setLayout(null);
		   j1.setVisible(true);
	}
	
//	Function Call of Admin Section
	
	void Studd() {
		j1.dispose();
		j2=new JFrame("Admin Panel");
		l6=new JLabel("Student Name");
		l6.setBounds(50,30,100,20);
		t2=new JTextField();
		t2.setBounds(160,30,100,20);
		l7=new JLabel("Roll no");
		l7.setBounds(50,60,70,20);
		t3=new JTextField();
		t3.setBounds(160,60,90,20);
		l8=new JLabel("Batch");
		l8.setBounds(50,90,90,20);
		t4=new JTextField();
		t4.setBounds(150,90,90,20);
		b8=new JButton("Add");
		b8.setBounds(50,120,100,20);
		b9=new JButton("Update");
		b9.setBounds(160,120,100,20);
		b10=new JButton("Delete");
		b10.setBounds(270,120,100,20);
		b11=new JButton("Display");
		b11.setBounds(380,120,100,20);
		j2.add(l6);
		j2.add(t2);
		j2.add(l7);
		j2.add(t3);
		j2.add(l8);
		j2.add(t4);
		j2.add(b8);
		j2.add(b9);
		j2.add(b10);
		j2.add(b11);
		j2.setLayout(null);
		j2.setSize(600,600);
		j2.setVisible(true);
		
//		Admin entering Student Data after selecting the Add Butoon
		b8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=t2.getText();
				String s1=t3.getText();
				String s2=t4.getText();
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				if(con!=null) {
					System.out.println("Connection Established");
				}else {
					System.out.println("Connection Failed");
				}
				
				 try {
					 if(s2.equals("1")) {
					ps=con.prepareStatement("insert into  studinfo(Roll_no,Student_name,Batch)values(?,?,?)");
					 }
					 else 
					 {
						 ps=con.prepareStatement("insert into  studinfo2(Roll_Number,Student_name,Batch)values(?,?,?)");

					 }
					ps.setString(1, s1);
					ps.setString(2,s);
					ps.setString(3, s2);
					int n=ps.executeUpdate();
					ps.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		b9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 String s = t2.getText();
			        String s1 = t3.getText();
			        String s2 = t4.getText();
			        
			        try {
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance", "root", "root");
			            
			            if (con != null) {
			                System.out.println("Connection Established");
			            } else {
			                System.out.println("Connection Failed");
			            }
			            
			            String updateQuery;
			            
			            if (s2.equals("1")) {
			                updateQuery = "UPDATE studinfo SET Student_name = ? WHERE Roll_no = ?";
			            } else {
			                updateQuery = "UPDATE studinfo2 SET Student_name = ? WHERE Roll_number = ?";
			            }
			            
			            PreparedStatement ps = con.prepareStatement(updateQuery);
			            ps.setString(1, s);
			            ps.setString(2, s1);
			            int rowsUpdated = ps.executeUpdate();

					
					}catch(Exception sql) {
						System.out.println("Not Running"+sql);
					
				}
				
			}
			
		});
		
		b10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=t2.getText();
				String s1=t3.getText();
				String s2=t4.getText();
				try {
					
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
					if(con!=null) {
						System.out.println("Connection Established");
					}else {
						System.out.println("Connection Failed");
					}
					if(s2.equals("1")) {
					ps=con.prepareStatement("Delete from studinfo  where Roll_no=?");
					}else {
						ps=con.prepareStatement("Delete from studinfo2 where Roll_number=?");
					}
					
					 ps.setString(1, s1);
					int n=ps.executeUpdate();
					ps.close();
					con.close();

					
					}catch(Exception sql) {
						System.out.println("Not Running"+sql);
					
				}
			}
			
		});
		
		
		b11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			
				j3=new JFrame("Admin Panel");
				
				l9=new JLabel("Which Batch You want to Display");
				l9.setBounds(50,50,250,20);
				rb3=new JRadioButton("Batch 1");
				rb3.setBounds(50,80,150,20);
				rb4=new JRadioButton("Batch 2");
				rb4.setBounds(50,110,150,20);	
				ButtonGroup bg=new ButtonGroup();
				bg.add(rb3);
				bg.add(rb4);
				j3.add(l9);
				j3.add(rb3);
				j3.add(rb4);
				b12=new JButton("Display Batch");
			    b12.setBounds(50,150,190,20);
				j3.add(b12);
				j3.setSize(600,600);
				j3.setLayout(null);
				j3.setVisible(true);
				b12.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						if(rb3.isSelected()) {
							Batch1();
						}
						else if(rb4.isSelected()) {
							Batch2();
						}
					}
					
				});
			}
			
		});

		
	}
//	After clicking The teacher radio button clicked by Admin
	void Teacherd() {
		j1.dispose();
		j2=new JFrame("Admin Panel");
		l6=new JLabel("Teacher Name");
		l6.setBounds(50,30,100,20);
		t2=new JTextField();
		t2.setBounds(160,30,100,20);
		l7=new JLabel("Teacher Id");
		l7.setBounds(50,60,70,20);
		t3=new JTextField();
		t3.setBounds(160,60,90,20);
		l8=new JLabel("Work Experience");
		l8.setBounds(50,90,150,20);
		t4=new JTextField();
		t4.setBounds(160,90,80,20);
		b8=new JButton("Add");
		b8.setBounds(50,150,100,20);
		b9=new JButton("Update");
		b9.setBounds(160,150,100,20);
		b10=new JButton("Delete");
		b10.setBounds(270,150,100,20);
		b11=new JButton("Display");
		b11.setBounds(380,150,100,20);
		j2.add(l6);
		j2.add(t2);
		j2.add(l7);
		j2.add(t3);
		j2.add(l8);
		j2.add(t4);	
		j2.add(b8);
		j2.add(b9);
		j2.add(b10);
		j2.add(b11);
		j2.setLayout(null);
		j2.setSize(600,600);
		j2.setVisible(true);
		
		
		b8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				String s=t2.getText();//Name
				String s1=t3.getText();//id
				String s2=t4.getText();//number value
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
				
				if(con!=null) {
					System.out.println("Connection Established");
				}else {
					System.out.println("Connection Failed");
				}
				
				ps=con.prepareStatement("insert into  teacherinfo(Teacher_id,Teacher_name,Teaching_experience)values(?,?,?)");
					 
					ps.setString(1, s1);
					ps.setString(2,s);
					ps.setString(3, s2);
					int n=ps.executeUpdate();
					ps.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		
		b9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = t2.getText();
		        String s1 = t3.getText();
		        String s2 = t4.getText();
		        
		        try {
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance", "root", "root");
		            
		            if (con != null) {
		                System.out.println("Connection Established");
		                
		                String updateQuery = "UPDATE teacherinfo SET Teacher_name = ?, Teaching_experience = ? WHERE Teacher_id = ?";
		                PreparedStatement ps = con.prepareStatement(updateQuery);
		                ps.setString(1, s);
		                ps.setString(2, s2);
		                ps.setString(3, s1);
		                int rowsUpdated = ps.executeUpdate();
		                ps.close();
		                con.close();
		            }
					}catch(Exception sql) {
						System.out.println("Not Running"+sql);
					
				}
				
			}
			
		});
		
		
		b10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s=t2.getText();
				String s1=t3.getText();
				String s2=t4.getText();
				
				try {
					
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
					if(con!=null) {
						System.out.println("Connection Established");
					}else {
						System.out.println("Connection Failed");
					}
					
					ps=con.prepareStatement("Delete from teacherinfo  where Teacher_id=?");
					 ps.setString(1, s1);
					int n=ps.executeUpdate();
					ps.close();
					con.close();

					
					}catch(Exception sql) {
						System.out.println("Not Running"+sql);
					
				}
			}
			
		});
		
		
		b11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				j3=new JFrame("Admin Panel");
				JTable jTable=new JTable();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
					if(con!=null) {
						System.out.println("Connection Established");
					}
					else {
						System.out.println("Connection Failed");
					}
					ps=con.prepareStatement("Select * from teacherinfo");
					rs=ps.executeQuery();
					ResultSetMetaData rsmd=rs.getMetaData();
					int n=rsmd.getColumnCount();
					 Vector<String> columns = new Vector<>();
				        for (int i = 1; i <= n; i++) {
				            columns.add(rsmd.getColumnName(i));
				        }
				        DefaultTableModel dtm = new DefaultTableModel(columns, 0);
				        while (rs.next()) {
				            Vector<String> rowData = new Vector<>();
				            for (int i = 1; i <= n; i++) {
				                rowData.add(rs.getString(i));
				            }
				            dtm.addRow(rowData);
				        }

				        jTable.setModel(dtm);
				} catch (ClassNotFoundException q) {
					q.printStackTrace();
				} catch (SQLException o) {
					o.printStackTrace();
				}
				 JScrollPane scrollPane = new JScrollPane(jTable);
				    scrollPane.setBounds(50, 50, 500, 400);

				    j3.add(scrollPane);
				j3.setLayout(null);
				j3.setSize(600,600);
				j3.setVisible(true);
				
			}
			
		});
	}
	
	
	
	
//	Teacher entering Student Data after selecting the teacher Butoon    After Teacher Button
	void StudTeach() {
		j.dispose();
		j1=new JFrame("Student Data");
		l5=new JLabel("Student Name");
		l5.setBounds(30,50,100,20);
		t2=new JTextField();
		t2.setBounds(140,50,100,20);
		l6=new JLabel("Roll no");
		l6.setBounds(30,80,100,20);
		t3=new JTextField();
		t3.setBounds(140,80,100,20);
		l7=new JLabel("Batch");
		l7.setBounds(30,110,100,20);
		t4=new JTextField();
		t4.setBounds(140,110,100,20);
		b7=new JButton("Upadate");
		b7.setBounds(50,150,100,20);
		b8=new JButton("Delete");
		b8.setBounds(160,150,100,20);
		b9=new JButton("Attendance");
		b9.setBounds(270,150,100,20);
		b10=new JButton("Display");
		b10.setBounds(380,150,100,20);
		j1.add(l5);
		j1.add(t2);
		j1.add(l6);
		j1.add(t3);
		j1.add(l7);
		j1.add(t4);
		j1.add(b7);
		j1.add(b8);
		j1.add(b9);
		j1.add(b10);
		j1.setLayout(null);
		j1.setSize(600,600);
		j1.setVisible(true);
		
		
		
		
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 String s = t2.getText();
			        String s1 = t3.getText();
			        String s2 = t4.getText();
			        
			        try {
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance", "root", "root");
			            
			            if (con != null) {
			                System.out.println("Connection Established");
			            } else {
			                System.out.println("Connection Failed");
			            }
			            
			            String updateQuery;
			            
			            if (s2.equals("1")) {
			                updateQuery = "UPDATE studinfo SET Student_name = ? WHERE Roll_no = ?";
			            } else {
			                updateQuery = "UPDATE studinfo2 SET Student_name = ? WHERE Roll_number = ?";
			            }
			            
			            PreparedStatement ps = con.prepareStatement(updateQuery);
			            ps.setString(1, s);
			            ps.setString(2, s1);
			            int rowsUpdated = ps.executeUpdate();

					
					}catch(Exception sql) {
						System.out.println("Not Running"+sql);
					
				}
				
			}
			
		});
		
		
		
		b8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=t2.getText();
				String s1=t3.getText();
				String s2=t4.getText();
				try {
					
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
					if(con!=null) {
						System.out.println("Connection Established");
					}else {
						System.out.println("Connection Failed");
					}
					if(s2.equals("1")) {
					ps=con.prepareStatement("Delete from studinfo  where Roll_no=?");
					}else {
						ps=con.prepareStatement("Delete from studinfo2 where Roll_number=?");
					}
					
					 ps.setString(1, s1);
					int n=ps.executeUpdate();
					ps.close();
					con.close();

					
					}catch(Exception sql) {
						System.out.println("Not Running"+sql);
					
				}
				
			}
			
			
		});
		
		
		b9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						j2=new JFrame("Attendance Slide");
						l8=new JLabel("Which Batch You want to Attendance");
						l8.setBounds(50,50,250,20);
						rb3=new JRadioButton("Batch 1");
						rb3.setBounds(50,80,150,20);
						rb4=new JRadioButton("Batch 2");
						rb4.setBounds(50,110,150,20);	
						ButtonGroup bg=new ButtonGroup();
						bg.add(rb3);
						bg.add(rb4);
						j2.add(l8);
						j2.add(rb3);
						j2.add(rb4);
						b12=new JButton("Display Batch");
					    b12.setBounds(50,150,190,20);
					    j2.add(b12);
						j2.setSize(600,600);
						j2.setLayout(null);
						j2.setVisible(true);
						
						b12.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if(rb3.isSelected()) {
									Batch_Attendance1();
								}else if(rb4.isSelected()) {
									Batch_Attendance2();
								}

							}
							
						});
						
					}
					
				});
		
		
		
		b10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				j2=new JFrame("Display Slide");
				l8=new JLabel("Which Batch You want to Attendance");
				l8.setBounds(50,50,250,20);
				rb3=new JRadioButton("Batch 1");
				rb3.setBounds(50,80,150,20);
				rb4=new JRadioButton("Batch 2");
				rb4.setBounds(50,110,150,20);	
				ButtonGroup bg=new ButtonGroup();
				bg.add(rb3);
				bg.add(rb4);
				j2.add(l8);
				j2.add(rb3);
				j2.add(rb4);
				b12=new JButton("Display Batch");
			    b12.setBounds(50,150,190,20);
			    j2.add(b12);
				j2.setSize(600,600);
				j2.setLayout(null);
				j2.setVisible(true);
				
				b12.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						j3=new JFrame("Display slide");
						JTable jTable=new JTable();
						if(rb3.isSelected()) {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
							if(con!=null) {
								System.out.println("Connection Established");
							}
							else {
								System.out.println("Connection Failed");
							}
							ps=con.prepareStatement("Select * from attendstud1");
							rs=ps.executeQuery();
							ResultSetMetaData rsmd=rs.getMetaData();
							int n=rsmd.getColumnCount();
							 Vector<String> columns = new Vector<>();
						        for (int i = 1; i <= n; i++) {
						            columns.add(rsmd.getColumnName(i));
						        }
						        DefaultTableModel dtm = new DefaultTableModel(columns, 0);
						        while (rs.next()) {
						            Vector<String> rowData = new Vector<>();
						            for (int i = 1; i <= n; i++) {
						                rowData.add(rs.getString(i));
						            }
						            dtm.addRow(rowData);
						        }

						        jTable.setModel(dtm);
						} catch (ClassNotFoundException q) {
							q.printStackTrace();
						} catch (SQLException o) {
							o.printStackTrace();
						}
						 JScrollPane scrollPane = new JScrollPane(jTable);
						    scrollPane.setBounds(50, 50, 500, 400);

						    j3.add(scrollPane);
						j3.setLayout(null);
						j3.setSize(600,600);
						j3.setVisible(true);
					}
						else if(rb4.isSelected()) {
							try {
								Class.forName("com.mysql.cj.jdbc.Driver");
								con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
								if(con!=null) {
									System.out.println("Connection Established");
								}
								else {
									System.out.println("Connection Failed");
								}
								ps=con.prepareStatement("Select * from attendstud2");
								rs=ps.executeQuery();
								ResultSetMetaData rsmd=rs.getMetaData();
								int n=rsmd.getColumnCount();
								 Vector<String> columns = new Vector<>();
							        for (int i = 1; i <= n; i++) {
							            columns.add(rsmd.getColumnName(i));
							        }
							        DefaultTableModel dtm = new DefaultTableModel(columns, 0);
							        while (rs.next()) {
							            Vector<String> rowData = new Vector<>();
							            for (int i = 1; i <= n; i++) {
							                rowData.add(rs.getString(i));
							            }
							            dtm.addRow(rowData);
							        }

							        jTable.setModel(dtm);
							} catch (ClassNotFoundException q) {
								q.printStackTrace();
							} catch (SQLException o) {
								o.printStackTrace();
							}
							 JScrollPane scrollPane = new JScrollPane(jTable);
							    scrollPane.setBounds(50, 50, 500, 400);

							    j3.add(scrollPane);
							j3.setLayout(null);
							j3.setSize(600,600);
							j3.setVisible(true);
						}
					}		
					
				});
				
				
			}
			
		});
			
		
	}
	
	
	
	
	
//	Teacher Taking Attenedance
	void Batch_Attendance1(){
		 jc = new JComboBox<String>();
		j4=new JFrame("Attendance");
		l13=new JLabel("Enter the Date");
		l13.setBounds(30,50,150,20);
		t7=new JTextField();
		t7.setBounds(150,50,150,20);
		l12=new JLabel("Roll_no");
		l12.setBounds(30,80,150,20);
		t6=new JTextField();
		t6.setBounds(150,80,150,20);
		l11=new JLabel("Student Name");
		l11.setBounds(30,120,150,20);
		 try {
//			 Adding Student name in comboBox
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance", "root", "root");
	            ps = con.prepareStatement("SELECT Student_name FROM studinfo");
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                String name = rs.getString("Student_name");
	                jc.addItem(name);
	            }
	           
	        } catch (SQLException sql) {
	            System.out.println(sql);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }   
	    jc.setBounds(150,120,190,20);
	    b13=new JButton("Select");
	    b13.setBounds(360,120,80,20);

	    rb5=new JRadioButton("Present");
	    rb5.setBounds(50,170,100,20);
	    rb6=new JRadioButton("Absent");
	    rb6.setBounds(160,170,100,20);
	    ButtonGroup bg=new ButtonGroup();
	    bg.add(rb5);
	    bg.add(rb6);
	    b14=new JButton("Submit");
	    b14.setBounds(80,220,80,30);
		j4.add(l12);
		j4.add(l13);
		j4.add(t6);
		j4.add(t7);
		j4.add(l11);
		j4.add(jc);
		j4.add(rb5);
		j4.add(rb6);
		j4.add(b13);
		j4.add(b14);
		j4.setLayout(null);
		j4.setSize(600,600);
		j4.setVisible(true);
		
		
		
		b13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    string1=(String) jc.getSelectedItem();
				System.out.println(string1);
			}
			
		});
	    
		b14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String radio = "";
				String d=t7.getText();
				String ro=t6.getText();
				
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
					if(con!=null) {
						System.out.println("Connection Established");
					}else {
						System.out.println("ConnectionFailed");
					}
					if(rb5.isSelected()) {
						radio="Present";
					}else if(rb6.isSelected()) {
						radio="Absent";
					}
					String temp="insert into attendstud1(Roll_no,Student_name,attend,Date) values (?,?,?,?)";
					ps=con.prepareStatement(temp);
					ps.setString(1, ro);
					ps.setString(2, string1);
					ps.setString(3, radio);
					ps.setString(4, d);
					System.out.println("Add Successfully");
					int n=ps.executeUpdate();
					con.close();
					ps.close();
				}catch(SQLException sql) {
					System.out.println(sql);
				}
			}
			
		});
		
		
	}
	
	void Batch_Attendance2() {
		
		 jc = new JComboBox<String>();
			j4=new JFrame("Attendance Batch 2");
			l13=new JLabel("Enter the Date");
			l13.setBounds(30,50,150,20);
			t7=new JTextField();
			t7.setBounds(150,50,150,20);
			l12=new JLabel("Roll_no");
			l12.setBounds(30,80,150,20);
			t6=new JTextField();
			t6.setBounds(150,80,150,20);
			l11=new JLabel("Student Name");
			l11.setBounds(30,120,150,20);
			 try {
//				 Adding Student name in comboBox
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance", "root", "root");
		            ps = con.prepareStatement("SELECT Student_name FROM studinfo2");
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                String name = rs.getString("Student_name");
		                jc.addItem(name);
		            }
		           
		        } catch (SQLException sql) {
		            System.out.println(sql);
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }   
		    jc.setBounds(150,120,190,20);
		    b13=new JButton("Select");
		    b13.setBounds(360,120,80,20);

		    rb5=new JRadioButton("Present");
		    rb5.setBounds(50,170,100,20);
		    rb6=new JRadioButton("Absent");
		    rb6.setBounds(160,170,100,20);
		    ButtonGroup bg=new ButtonGroup();
		    bg.add(rb5);
		    bg.add(rb6);
		    b14=new JButton("Submit");
		    b14.setBounds(80,220,80,30);
			j4.add(l12);
			j4.add(l13);
			j4.add(t6);
			j4.add(t7);
			j4.add(l11);
			j4.add(jc);
			j4.add(rb5);
			j4.add(rb6);
			j4.add(b13);
			j4.add(b14);
			j4.setLayout(null);
			j4.setSize(600,600);
			j4.setVisible(true);
			
			
			
			b13.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				    string1=(String) jc.getSelectedItem();
					System.out.println(string1);
				}
				
			});
		    
		
			 
			b14.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String radio = "";
					String d=t7.getText();
					String ro=t6.getText();
					
					try {
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
						if(con!=null) {
							System.out.println("Connection Established");
						}else {
							System.out.println("ConnectionFailed");
						}
						if(rb5.isSelected()) {
							radio="Present";
						}else if(rb6.isSelected()) {
							radio="Absent";
						}
						String temp="insert into attendstud2(Roll_no,Student_name,attend,Date) values (?,?,?,?)";
						ps=con.prepareStatement(temp);
						ps.setString(1, ro);
						ps.setString(2, string1);
						ps.setString(3, radio);
						ps.setString(4, d);
						System.out.println("Add Successfully");
						int n=ps.executeUpdate();
						con.close();
						ps.close();
					}catch(SQLException sql) {
						System.out.println(sql);
					}
				}
				
			});
	}
	
//	Admin Diplaying The Student Information 
	void Batch1() {
		j4=new JFrame("Admin Panel");
		JTable jTable=new JTable();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
			if(con!=null) {
				System.out.println("Connection Established");
			}
			else {
				System.out.println("Connection Failed");
			}
			ps=con.prepareStatement("Select * from studinfo");
			rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int n=rsmd.getColumnCount();
			 Vector<String> columns = new Vector<>();
		        for (int i = 1; i <= n; i++) {
		            columns.add(rsmd.getColumnName(i));
		        }
		        DefaultTableModel dtm = new DefaultTableModel(columns, 0);
		        while (rs.next()) {
		            Vector<String> rowData = new Vector<>();
		            for (int i = 1; i <= n; i++) {
		                rowData.add(rs.getString(i));
		            }
		            dtm.addRow(rowData);
		        }

		        jTable.setModel(dtm);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 JScrollPane scrollPane = new JScrollPane(jTable);
		    scrollPane.setBounds(50, 50, 500, 400);

		    j4.add(scrollPane);
		j4.setLayout(null);
		j4.setSize(600,600);
		j4.setVisible(true);
	}
	void Batch2(){
		
		j4=new JFrame("Admin Panel");
		JTable jTable=new JTable();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
			if(con!=null) {
				System.out.println("Connection Established");
			}
			else {
				System.out.println("Connection Failed");
			}
			ps=con.prepareStatement("Select * from studinfo2");
			rs=ps.executeQuery();										 
			ResultSetMetaData rsmd=rs.getMetaData();
			int n=rsmd.getColumnCount();
			 Vector<String> columns = new Vector<>();
		        for (int i = 1; i <= n; i++) {
		            columns.add(rsmd.getColumnName(i));
		        }
		        DefaultTableModel dtm = new DefaultTableModel(columns, 0);
		        while (rs.next()) {
		            Vector<String> rowData = new Vector<>();
		            for (int i = 1; i <= n; i++) {
		                rowData.add(rs.getString(i));
		            }
		            dtm.addRow(rowData);
		        }

		        jTable.setModel(dtm);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 JScrollPane scrollPane = new JScrollPane(jTable);
		    scrollPane.setBounds(50, 50, 500, 400);

		    j4.add(scrollPane);
		j4.setLayout(null);
		j4.setSize(600,600);
		j4.setVisible(true);
	}

	public static void main(String[] args) {
		Attendance a=new Attendance();
	}

}	
