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
    public partial class AssignTeacher : Form
    {
        protected int idInt;
        private BusinessController businessControl;
        private AddTaughtCourse addCourse;
        public AssignTeacher(BusinessController controller)
        {
            InitializeComponent();
            businessControl = controller;
            addCourse = new AddTaughtCourse(null,this, controller);
            InitializeCollections();
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
        protected virtual bool fieldsOK()
        {
            return
                !string.IsNullOrEmpty(studentComboBox.Text) &&
                !string.IsNullOrEmpty(tcComboBox.Text);
        }
        
        public void addTaughtCourseConfirmed(TaughtCourse course)
        {

            BindingList<TaughtCourse> courses = new BindingList<TaughtCourse>((IList<TaughtCourse>)tcComboBox.DataSource);
            courses.Add(course);

            tcComboBox.DataSource = courses;
            tcComboBox.SelectedItem = course;
        }
        private void AssignTeacher_Load(object sender, EventArgs e)
        {

        }

        private void bTC_Click(object sender, EventArgs e)
        {
            addCourse.ShowDialog();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void assignTbutton_Click(object sender, EventArgs e)
        {

        }
    }
}
