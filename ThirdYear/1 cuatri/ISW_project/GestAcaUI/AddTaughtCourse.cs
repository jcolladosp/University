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
    
    public partial class AddTaughtCourse : Form
    {
        private BusinessController businessControl;
        private AddCourse addCourse;
        private AddEnrollment addEnrollment;
        private AssignTeacher assignTeacher;
        private int idTC;
        private int durationTC;
        private int priceTC;
        private int quotaTC;



        public AddTaughtCourse(AddEnrollment addEnrollment,AssignTeacher assignTeacher, BusinessController controller)
        {
            InitializeComponent();
            businessControl = controller;
            addCourse = new AddCourse(this,controller);
            this.addEnrollment = addEnrollment;
            this.assignTeacher = assignTeacher;
            InitializeCollections();
        }

 
        private void addCustomerbutton_Click(object sender, EventArgs e)
        {
            addCourse.ShowDialog();
        }
        public void InitializeCollections()
        {
            courseComboBox.DisplayMember = "Name";
            courseComboBox.ValueMember = "Name";
            courseComboBox.DataSource = businessControl.findAllCourses();
            courseComboBox.SelectedIndex = -1;
        }

        protected virtual bool fieldsOK()
        {
            return

                int.TryParse(quotatextBox.Text, out quotaTC) &&
                int.TryParse(pricetextBox.Text, out priceTC) &&
                int.TryParse(durationtextBox.Text, out durationTC) &&
                !string.IsNullOrEmpty(teachingtextBox.Text) &&
                (courseComboBox.SelectedIndex != -1) &&
                int.TryParse(quotatextBox.Text, out quotaTC) &&
                int.TryParse(idtextBox.Text, out idTC);

        }
        public virtual void Clear()
        {
            quotatextBox.Clear();
            pricetextBox.Clear();
            durationtextBox.Clear();
            idtextBox.Clear();
            teachingtextBox.Clear();
            courseComboBox.SelectedIndex = -1;
        
        }

        private void addTCButton_Click(object sender, EventArgs e)
        {
            if (fieldsOK())
            {
                addTC();
            }
            else MessageBox.Show("Missing Fields or not valid format", "Error");
        }

        private void addTC()
        {
            if (businessControl.findTaughtCourseById(idTC) != null)
                MessageBox.Show("TaughtCourse with this ID already exists", "Error");
            else
            {
                Course course = (Course)courseComboBox.SelectedItem;
                TaughtCourse tc = new TaughtCourse(idTC, endTimePicker.Value, startTimePicker.Value, teachingtextBox.Text, durationTC, priceTC, quotaTC, course);
                businessControl.addTaughtCourse(tc);
                if (addEnrollment!=null) { addEnrollment.addTaughtCourseConfirmed(tc); }
                if (assignTeacher != null) { assignTeacher.addTaughtCourseConfirmed(tc); }
                MessageBox.Show("Taught Course added correctly");
                Close();
            }
        }

        public void addCourseConfirmed(Course course)
        {

            BindingList<Course> courses = new BindingList<Course>((IList<Course>)courseComboBox.DataSource);
            courses.Add(course);

            courseComboBox.DataSource = courses;
            courseComboBox.SelectedItem = course;
        }

        private void AddTaughtCourse_Load(object sender, EventArgs e)
        {
            Clear();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
