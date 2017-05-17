namespace GestAcaUI
{
    partial class AddEnrollment
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(AddEnrollment));
            this.label4 = new System.Windows.Forms.Label();
            this.idtextBox = new System.Windows.Forms.TextBox();
            this.startTimePicker = new System.Windows.Forms.DateTimePicker();
            this.endTimePicker = new System.Windows.Forms.DateTimePicker();
            this.checkBox1 = new System.Windows.Forms.CheckBox();
            this.studentComboBox = new System.Windows.Forms.ComboBox();
            this.tcComboBox = new System.Windows.Forms.ComboBox();
            this.addTCButton = new System.Windows.Forms.Button();
            this.addCustomerbutton = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(87, 32);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(18, 13);
            this.label4.TabIndex = 18;
            this.label4.Text = "ID";
            // 
            // idtextBox
            // 
            this.idtextBox.Location = new System.Drawing.Point(127, 29);
            this.idtextBox.Name = "idtextBox";
            this.idtextBox.Size = new System.Drawing.Size(100, 20);
            this.idtextBox.TabIndex = 19;
            // 
            // startTimePicker
            // 
            this.startTimePicker.Location = new System.Drawing.Point(127, 72);
            this.startTimePicker.Name = "startTimePicker";
            this.startTimePicker.Size = new System.Drawing.Size(200, 20);
            this.startTimePicker.TabIndex = 20;
            // 
            // endTimePicker
            // 
            this.endTimePicker.Location = new System.Drawing.Point(127, 112);
            this.endTimePicker.Name = "endTimePicker";
            this.endTimePicker.Size = new System.Drawing.Size(200, 20);
            this.endTimePicker.TabIndex = 21;
            // 
            // checkBox1
            // 
            this.checkBox1.AutoSize = true;
            this.checkBox1.Location = new System.Drawing.Point(115, 273);
            this.checkBox1.Name = "checkBox1";
            this.checkBox1.Size = new System.Drawing.Size(60, 17);
            this.checkBox1.TabIndex = 22;
            this.checkBox1.Text = "Unique";
            this.checkBox1.UseVisualStyleBackColor = true;
            // 
            // studentComboBox
            // 
            this.studentComboBox.FormattingEnabled = true;
            this.studentComboBox.Location = new System.Drawing.Point(127, 149);
            this.studentComboBox.Name = "studentComboBox";
            this.studentComboBox.Size = new System.Drawing.Size(143, 21);
            this.studentComboBox.TabIndex = 23;
            this.studentComboBox.SelectedIndexChanged += new System.EventHandler(this.studentComboBox_SelectedIndexChanged);
            // 
            // tcComboBox
            // 
            this.tcComboBox.FormattingEnabled = true;
            this.tcComboBox.Location = new System.Drawing.Point(127, 189);
            this.tcComboBox.Name = "tcComboBox";
            this.tcComboBox.Size = new System.Drawing.Size(143, 21);
            this.tcComboBox.TabIndex = 24;
            this.tcComboBox.SelectedIndexChanged += new System.EventHandler(this.tcComboBox_SelectedIndexChanged);
            // 
            // addTCButton
            // 
            this.addTCButton.Location = new System.Drawing.Point(252, 269);
            this.addTCButton.Name = "addTCButton";
            this.addTCButton.Size = new System.Drawing.Size(75, 23);
            this.addTCButton.TabIndex = 26;
            this.addTCButton.Text = "Add";
            this.addTCButton.UseVisualStyleBackColor = true;
            this.addTCButton.Click += new System.EventHandler(this.addTCButton_Click);
            // 
            // addCustomerbutton
            // 
            this.addCustomerbutton.Location = new System.Drawing.Point(276, 187);
            this.addCustomerbutton.Name = "addCustomerbutton";
            this.addCustomerbutton.Size = new System.Drawing.Size(51, 23);
            this.addCustomerbutton.TabIndex = 27;
            this.addCustomerbutton.Text = "New Customer";
            this.addCustomerbutton.UseVisualStyleBackColor = true;
            this.addCustomerbutton.Click += new System.EventHandler(this.addCustomerbutton_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(276, 147);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(51, 23);
            this.button1.TabIndex = 28;
            this.button1.Text = "New Customer";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(23, 78);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(82, 13);
            this.label1.TabIndex = 29;
            this.label1.Text = "Enrollment Date";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(14, 118);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(91, 13);
            this.label2.TabIndex = 30;
            this.label2.Text = "Cancellation Date";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(61, 152);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(44, 13);
            this.label3.TabIndex = 31;
            this.label3.Text = "Student";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(28, 192);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(77, 13);
            this.label5.TabIndex = 32;
            this.label5.Text = "Taught Course";
            this.label5.Click += new System.EventHandler(this.label5_Click);
            // 
            // AddEnrollment
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(339, 304);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.addCustomerbutton);
            this.Controls.Add(this.addTCButton);
            this.Controls.Add(this.tcComboBox);
            this.Controls.Add(this.studentComboBox);
            this.Controls.Add(this.checkBox1);
            this.Controls.Add(this.endTimePicker);
            this.Controls.Add(this.startTimePicker);
            this.Controls.Add(this.idtextBox);
            this.Controls.Add(this.label4);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "AddEnrollment";
            this.Text = "AddEnrollment";
            this.Load += new System.EventHandler(this.AddEnrollment_Load_1);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label4;
        protected System.Windows.Forms.TextBox idtextBox;
        private System.Windows.Forms.DateTimePicker startTimePicker;
        private System.Windows.Forms.DateTimePicker endTimePicker;
        private System.Windows.Forms.CheckBox checkBox1;
        private System.Windows.Forms.ComboBox studentComboBox;
        private System.Windows.Forms.ComboBox tcComboBox;
        protected System.Windows.Forms.Button addTCButton;
        private System.Windows.Forms.Button addCustomerbutton;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label5;
    }
}