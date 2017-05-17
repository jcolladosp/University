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
    public partial class AddCourse : Form
    {
        protected int idInt;
        private AddTaughtCourse addTaughtCourse;
        private BusinessController businessControl;
        public AddCourse(AddTaughtCourse addTaughtCourse,BusinessController controller)
        {
            InitializeComponent();
            businessControl = controller;
            this.addTaughtCourse = addTaughtCourse;
        }

        protected virtual bool fieldsOK()
        {
            return
                !string.IsNullOrEmpty(idTextBox.Text) &&
                !string.IsNullOrEmpty(nameTextBox.Text) &&
                !string.IsNullOrEmpty(descriptionTextBox.Text)
                && int.TryParse(idTextBox.Text, out idInt); 
        }

        public virtual void Clear()
        {
            idTextBox.Clear();
            nameTextBox.Clear();
            descriptionTextBox.Clear();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void addButton_Click(object sender, EventArgs e)
        {
            if (fieldsOK())
            {
                if (businessControl.findCourseByID(idInt) != null)
                    MessageBox.Show("Course with this ID already exists", "Error");
                else
                {
                    Course c = new Course(idInt, nameTextBox.Text, descriptionTextBox.Text);
                    businessControl.addCourse(c);
                    addTaughtCourse.addCourseConfirmed(c);
                    MessageBox.Show("Course added correctly", "Success");
                    Close();
                }


            }
            else MessageBox.Show("Missing Fields or not valid format", "Error");
        }

        private void AddCourse_Load(object sender, EventArgs e)
        {
            Clear();
        }

        private void idLabel_Click(object sender, EventArgs e)
        {

        }
    }
}
