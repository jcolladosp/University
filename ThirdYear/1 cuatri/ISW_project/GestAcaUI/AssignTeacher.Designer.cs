namespace GestAcaUI
{
    partial class AssignTeacher
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(AssignTeacher));
            this.studentComboBox = new System.Windows.Forms.ComboBox();
            this.tcComboBox = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.bTC = new System.Windows.Forms.Button();
            this.assignTbutton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // studentComboBox
            // 
            this.studentComboBox.FormattingEnabled = true;
            this.studentComboBox.Location = new System.Drawing.Point(80, 22);
            this.studentComboBox.Name = "studentComboBox";
            this.studentComboBox.Size = new System.Drawing.Size(143, 21);
            this.studentComboBox.TabIndex = 24;
            // 
            // tcComboBox
            // 
            this.tcComboBox.FormattingEnabled = true;
            this.tcComboBox.Location = new System.Drawing.Point(80, 61);
            this.tcComboBox.Name = "tcComboBox";
            this.tcComboBox.Size = new System.Drawing.Size(143, 21);
            this.tcComboBox.TabIndex = 25;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(30, 25);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(47, 13);
            this.label3.TabIndex = 32;
            this.label3.Text = "Teacher";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(0, 64);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(74, 13);
            this.label1.TabIndex = 33;
            this.label1.Text = "TaughtCourse";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // bTC
            // 
            this.bTC.Location = new System.Drawing.Point(229, 59);
            this.bTC.Name = "bTC";
            this.bTC.Size = new System.Drawing.Size(51, 23);
            this.bTC.TabIndex = 35;
            this.bTC.Text = "New Customer";
            this.bTC.UseVisualStyleBackColor = true;
            this.bTC.Click += new System.EventHandler(this.bTC_Click);
            // 
            // assignTbutton
            // 
            this.assignTbutton.Location = new System.Drawing.Point(205, 215);
            this.assignTbutton.Name = "assignTbutton";
            this.assignTbutton.Size = new System.Drawing.Size(75, 23);
            this.assignTbutton.TabIndex = 36;
            this.assignTbutton.Text = "Add";
            this.assignTbutton.UseVisualStyleBackColor = true;
            this.assignTbutton.Click += new System.EventHandler(this.assignTbutton_Click);
            // 
            // AssignTeacher
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(302, 261);
            this.Controls.Add(this.assignTbutton);
            this.Controls.Add(this.bTC);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.tcComboBox);
            this.Controls.Add(this.studentComboBox);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "AssignTeacher";
            this.Text = "AssignTeacher";
            this.Load += new System.EventHandler(this.AssignTeacher_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox studentComboBox;
        private System.Windows.Forms.ComboBox tcComboBox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button bTC;
        protected System.Windows.Forms.Button assignTbutton;
    }
}