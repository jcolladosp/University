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
    public partial class AddEnrollment : Form
    {
        private AddStudent addStudent;
        private AddTaughtCourse addTC;
        private int idE;
        private BusinessController businessControl;

        public AddEnrollment(BusinessController controller)
        {
            InitializeComponent();

            addStudent = new AddStudent(this, controller);
            addTC = new AddTaughtCourse(this,null,controller);
            businessControl = controller;
            InitializeCollections();
        }
        protected virtual bool fieldsOK()
        {
            return
                !string.IsNullOrEmpty(idtextBox.Text) &&
                (studentComboBox.SelectedIndex != -1) &&
                (tcComboBox.SelectedIndex != -1) && 
                int.TryParse(idtextBox.Text, out idE); 
        }
        public  void Clear()
        {
            idtextBox.Clear();
            tcComboBox.SelectedIndex = -1;
            studentComboBox.SelectedIndex = -1;

        }

        private void addTCButton_Click(object sender, EventArgs e)
        {
            if (fieldsOK())
            {
                addE();
            }
            else MessageBox.Show("Missing Fields or not valid format", "Error");
        }
        private void addE()
        {
            if (checkBox1.Checked) {
                if (businessControl.findEnrollmentByID(idE) != null)
                    MessageBox.Show("Enrollment with this ID already exists", "Error");
            }
            
            else
            {
                try
                {
                    Student student = (Student)studentComboBox.SelectedItem;
                    TaughtCourse tc = (TaughtCourse)tcComboBox.SelectedItem;
                    businessControl.addEnrollment(new Enrollment(idE, startTimePicker.Value, endTimePicker.Value, checkBox1.Checked, student, tc));
                    MessageBox.Show("Enrollment added correctly");
                    Close();
                }
                catch (BusinessLogicException a) { MessageBox.Show(a.Message); }
            }
        }
        public void addTaughtCourseConfirmed(TaughtCourse course)
        {

            BindingList<TaughtCourse> courses = new BindingList<TaughtCourse>((IList<TaughtCourse>)tcComboBox.DataSource);
            courses.Add(course);

            tcComboBox.DataSource = courses;
            tcComboBox.SelectedItem = course;
        }

        public void addPersonFormConfirmed(Student s)
        {

            BindingList<Student> stds = new BindingList<Student>((IList<Student>)studentComboBox.DataSource);
            stds.Add(s);

            studentComboBox.DataSource = stds;
            studentComboBox.SelectedItem = s;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            addStudent.ShowDialog();
        }

        private void addCustomerbutton_Click(object sender, EventArgs e)
        {
            addTC.ShowDialog();
        }

        private void AddEnrollment_Load(object sender, EventArgs e)
        {
            Clear();
        }
        public void InitializeCollections()
        {
            studentComboBox.DisplayMember = "Name";
            studentComboBox.ValueMember = "Name";
            studentComboBox.DataSource = businessControl.findAllStudents();
            studentComboBox.SelectedIndex = -1;

            tcComboBox.DisplayMember = "Id";
            tcComboBox.ValueMember = "Id";
            tcComboBox.DataSource = businessControl.findAllTaughtCourses();
            tcComboBox.SelectedIndex = -1;
        }

        private void studentComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void tcComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void AddEnrollment_Load_1(object sender, EventArgs e)
        {
            
        }

    }
}
