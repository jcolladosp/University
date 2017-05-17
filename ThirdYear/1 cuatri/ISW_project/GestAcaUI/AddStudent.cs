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
    public partial class AddStudent : Form
    {   
        protected int zipCodeInt;
        protected AddEnrollment addEnrollmentForm;
        protected BusinessController businessControl;
        public AddStudent(AddEnrollment addEnrollmentForm, BusinessController control)
        {
            
            InitializeComponent();
            this.addEnrollmentForm = addEnrollmentForm;
            businessControl = control;
       
        }

        protected virtual bool fieldsOK()
        {
            return
                !string.IsNullOrEmpty(dnitextBox.Text) &&
                !string.IsNullOrEmpty(nametextBox.Text) &&
                !string.IsNullOrEmpty(addresstextBox.Text) &&
                !string.IsNullOrEmpty(ibantextBox.Text) &&
                int.TryParse(zipcodetextBox.Text, out zipCodeInt);

        }
        public virtual void Clear()
        {
            dnitextBox.Clear();
            nametextBox.Clear();
            addresstextBox.Clear();
            ibantextBox.Clear();
            zipcodetextBox.Clear();
        }

        private void addStudentButton_Click(object sender, EventArgs e)
        {
            if (fieldsOK())
            {
                if (businessControl.findStudentByID(dnitextBox.Text) != null)
                    MessageBox.Show("Student with this ID already exists", "Error");
                else
                {
                    Student s = new Student(dnitextBox.Text, nametextBox.Text, addresstextBox.Text,zipCodeInt,ibantextBox.Text);
                    businessControl.addStudent(s);
                    addEnrollmentForm.addPersonFormConfirmed(s);
                    MessageBox.Show("Student added correctly");
                    Close();
                }


            }
            else MessageBox.Show("Missing Fields or not valid format", "Error");
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
