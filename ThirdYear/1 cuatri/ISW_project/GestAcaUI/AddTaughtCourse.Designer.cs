namespace GestAcaUI
{
    partial class AddTaughtCourse
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(AddTaughtCourse));
            this.addCustomerbutton = new System.Windows.Forms.Button();
            this.courseComboBox = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.startTimePicker = new System.Windows.Forms.DateTimePicker();
            this.label5 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.endTimePicker = new System.Windows.Forms.DateTimePicker();
            this.idtextBox = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.teachingtextBox = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.durationtextBox = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.pricetextBox = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.addTCButton = new System.Windows.Forms.Button();
            this.quotatextBox = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // addCustomerbutton
            // 
            this.addCustomerbutton.Location = new System.Drawing.Point(249, 30);
            this.addCustomerbutton.Name = "addCustomerbutton";
            this.addCustomerbutton.Size = new System.Drawing.Size(51, 23);
            this.addCustomerbutton.TabIndex = 5;
            this.addCustomerbutton.Text = "New Customer";
            this.addCustomerbutton.UseVisualStyleBackColor = true;
            this.addCustomerbutton.Click += new System.EventHandler(this.addCustomerbutton_Click);
            // 
            // courseComboBox
            // 
            this.courseComboBox.FormattingEnabled = true;
            this.courseComboBox.Location = new System.Drawing.Point(100, 31);
            this.courseComboBox.Name = "courseComboBox";
            this.courseComboBox.Size = new System.Drawing.Size(143, 21);
            this.courseComboBox.TabIndex = 4;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(43, 35);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(40, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Course";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // startTimePicker
            // 
            this.startTimePicker.Location = new System.Drawing.Point(100, 103);
            this.startTimePicker.Name = "startTimePicker";
            this.startTimePicker.Size = new System.Drawing.Size(200, 20);
            this.startTimePicker.TabIndex = 14;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(28, 109);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(55, 13);
            this.label5.TabIndex = 13;
            this.label5.Text = "Start Date";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(33, 144);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(52, 13);
            this.label2.TabIndex = 15;
            this.label2.Text = "End Date";
            // 
            // endTimePicker
            // 
            this.endTimePicker.Location = new System.Drawing.Point(100, 144);
            this.endTimePicker.Name = "endTimePicker";
            this.endTimePicker.Size = new System.Drawing.Size(200, 20);
            this.endTimePicker.TabIndex = 16;
            // 
            // idtextBox
            // 
            this.idtextBox.Location = new System.Drawing.Point(100, 68);
            this.idtextBox.Name = "idtextBox";
            this.idtextBox.Size = new System.Drawing.Size(100, 20);
            this.idtextBox.TabIndex = 18;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(65, 75);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(18, 13);
            this.label4.TabIndex = 17;
            this.label4.Text = "ID";
            // 
            // teachingtextBox
            // 
            this.teachingtextBox.Location = new System.Drawing.Point(100, 182);
            this.teachingtextBox.Name = "teachingtextBox";
            this.teachingtextBox.Size = new System.Drawing.Size(100, 20);
            this.teachingtextBox.TabIndex = 20;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(9, 185);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(74, 13);
            this.label3.TabIndex = 19;
            this.label3.Text = "Teaching Day";
            // 
            // durationtextBox
            // 
            this.durationtextBox.Location = new System.Drawing.Point(147, 217);
            this.durationtextBox.Name = "durationtextBox";
            this.durationtextBox.Size = new System.Drawing.Size(61, 20);
            this.durationtextBox.TabIndex = 22;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(9, 220);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(132, 13);
            this.label6.TabIndex = 21;
            this.label6.Text = "Session Duration (minutes)";
            // 
            // pricetextBox
            // 
            this.pricetextBox.Location = new System.Drawing.Point(147, 255);
            this.pricetextBox.Name = "pricetextBox";
            this.pricetextBox.Size = new System.Drawing.Size(61, 20);
            this.pricetextBox.TabIndex = 24;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(74, 262);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(58, 13);
            this.label7.TabIndex = 23;
            this.label7.Text = "Total Price";
            // 
            // addTCButton
            // 
            this.addTCButton.Location = new System.Drawing.Point(225, 322);
            this.addTCButton.Name = "addTCButton";
            this.addTCButton.Size = new System.Drawing.Size(75, 23);
            this.addTCButton.TabIndex = 25;
            this.addTCButton.Text = "Add";
            this.addTCButton.UseVisualStyleBackColor = true;
            this.addTCButton.Click += new System.EventHandler(this.addTCButton_Click);
            // 
            // quotatextBox
            // 
            this.quotatextBox.Location = new System.Drawing.Point(147, 292);
            this.quotatextBox.Name = "quotatextBox";
            this.quotatextBox.Size = new System.Drawing.Size(61, 20);
            this.quotatextBox.TabIndex = 27;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(74, 299);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(36, 13);
            this.label8.TabIndex = 26;
            this.label8.Text = "Quota";
            // 
            // AddTaughtCourse
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(313, 357);
            this.Controls.Add(this.quotatextBox);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.addTCButton);
            this.Controls.Add(this.pricetextBox);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.durationtextBox);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.teachingtextBox);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.idtextBox);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.endTimePicker);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.startTimePicker);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.addCustomerbutton);
            this.Controls.Add(this.courseComboBox);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "AddTaughtCourse";
            this.Text = "Add Taught Course";
            this.Load += new System.EventHandler(this.AddTaughtCourse_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button addCustomerbutton;
        private System.Windows.Forms.ComboBox courseComboBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DateTimePicker startTimePicker;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.DateTimePicker endTimePicker;
        protected System.Windows.Forms.TextBox idtextBox;
        private System.Windows.Forms.Label label4;
        protected System.Windows.Forms.TextBox teachingtextBox;
        private System.Windows.Forms.Label label3;
        protected System.Windows.Forms.TextBox durationtextBox;
        private System.Windows.Forms.Label label6;
        protected System.Windows.Forms.TextBox pricetextBox;
        private System.Windows.Forms.Label label7;
        protected System.Windows.Forms.Button addTCButton;
        protected System.Windows.Forms.TextBox quotatextBox;
        private System.Windows.Forms.Label label8;
    }
}