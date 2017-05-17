using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;


using GestAcaLib.Entities;
using GestAcaLib.BusinessLogic;

namespace GestAcaUI
{
    public partial class GestAcaApp : Form
    {

        private BusinessController businessControl;
        private AddEnrollment addEnrollment;
        private AddTaughtCourse addTaughtCourse;
        private AssignTeacher assignTeacher;

        public GestAcaApp()
        {
            InitializeComponent();
            IntiliazeForms();
        }
        private void IntiliazeForms()
        {
            businessControl = BusinessController.getBusinessController();
            addEnrollment = new AddEnrollment(businessControl);
            addTaughtCourse = new AddTaughtCourse(null,null,businessControl);
            assignTeacher = new AssignTeacher(businessControl);
            menuStrip1.Visible = false;
        }
        private void GestAcaApp_Load(object sender, EventArgs e)
        {

        }

     



        private void addEnrollmentToolStripMenuItem_Click(object sender, EventArgs e)
        {
            addEnrollment.Clear();
            this.addEnrollment.ShowDialog();

        }

        private void addTaughtCourseToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
            this.addTaughtCourse.ShowDialog();
        }

        private void assignTeacherToolStripMenuItem_Click(object sender, EventArgs e)
        {
           
            this.assignTeacher.ShowDialog();
        }

        private void createExampleDBToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                //Add courses
                businessControl.addCourse(new Course(1, "Lockpicking Course", ""));
                businessControl.addCourse(new Course(2, "Android for Beginners", ""));
                businessControl.addCourse(new Course(3, "Be a Trollito in just 8 minutes", ""));

                //Add students
                businessControl.addStudent(new Student("1", "Javier Rodriguez", "", 0, ""));
                businessControl.addStudent(new Student("2", "Txus Velez", "", 0, ""));

                //Add teachers
                businessControl.addTeacher(new Teacher("3", "Salva Samaro", "", 0, "456"));
                businessControl.addTeacher(new Teacher("4", "Jaime Ferrando", "", 46799, "789"));

                MessageBox.Show("Database Created Sucessfully");
                IntiliazeForms();
            }
            catch (BusinessLogicException) {
                MessageBox.Show("Database Created Sucessfully");
                IntiliazeForms();
            }
        }

        private void loginButton_Click(object sender, EventArgs e)
        {
            menuStrip1.Visible = true;

            if(userComboBox.SelectedIndex == 0)
            {
                adToolStripMenuItem.Visible = false;
                employeeToolStripMenuItem.Visible = true;
            }
            if (userComboBox.SelectedIndex == 1)
            {
                adToolStripMenuItem.Visible = true;
                employeeToolStripMenuItem.Visible = false;
            }
        }
    }
}
