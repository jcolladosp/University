namespace GestAcaUI
{
    partial class GestAcaApp
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(GestAcaApp));
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.employeeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.addEnrollmentToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.adToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.addTaughtCourseToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.assignTeacherToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.createExampleDBToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.userComboBox = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.passwordTextBox = new System.Windows.Forms.TextBox();
            this.loginButton = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.menuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.employeeToolStripMenuItem,
            this.adToolStripMenuItem,
            this.createExampleDBToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Padding = new System.Windows.Forms.Padding(8, 2, 0, 2);
            this.menuStrip1.Size = new System.Drawing.Size(434, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // employeeToolStripMenuItem
            // 
            this.employeeToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.addEnrollmentToolStripMenuItem});
            this.employeeToolStripMenuItem.Name = "employeeToolStripMenuItem";
            this.employeeToolStripMenuItem.Size = new System.Drawing.Size(71, 20);
            this.employeeToolStripMenuItem.Text = "Employee";
            // 
            // addEnrollmentToolStripMenuItem
            // 
            this.addEnrollmentToolStripMenuItem.Name = "addEnrollmentToolStripMenuItem";
            this.addEnrollmentToolStripMenuItem.Size = new System.Drawing.Size(157, 22);
            this.addEnrollmentToolStripMenuItem.Text = "Add Enrollment";
            this.addEnrollmentToolStripMenuItem.Click += new System.EventHandler(this.addEnrollmentToolStripMenuItem_Click);
            // 
            // adToolStripMenuItem
            // 
            this.adToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.addTaughtCourseToolStripMenuItem,
            this.assignTeacherToolStripMenuItem});
            this.adToolStripMenuItem.Name = "adToolStripMenuItem";
            this.adToolStripMenuItem.Size = new System.Drawing.Size(92, 20);
            this.adToolStripMenuItem.Text = "Administrator";
            // 
            // addTaughtCourseToolStripMenuItem
            // 
            this.addTaughtCourseToolStripMenuItem.Name = "addTaughtCourseToolStripMenuItem";
            this.addTaughtCourseToolStripMenuItem.Size = new System.Drawing.Size(247, 22);
            this.addTaughtCourseToolStripMenuItem.Text = "Add Taught Course";
            this.addTaughtCourseToolStripMenuItem.Click += new System.EventHandler(this.addTaughtCourseToolStripMenuItem_Click);
            // 
            // assignTeacherToolStripMenuItem
            // 
            this.assignTeacherToolStripMenuItem.Name = "assignTeacherToolStripMenuItem";
            this.assignTeacherToolStripMenuItem.Size = new System.Drawing.Size(247, 22);
            this.assignTeacherToolStripMenuItem.Text = "Assign Teacher to Taught Course";
            this.assignTeacherToolStripMenuItem.Click += new System.EventHandler(this.assignTeacherToolStripMenuItem_Click);
            // 
            // createExampleDBToolStripMenuItem
            // 
            this.createExampleDBToolStripMenuItem.Name = "createExampleDBToolStripMenuItem";
            this.createExampleDBToolStripMenuItem.Size = new System.Drawing.Size(118, 20);
            this.createExampleDBToolStripMenuItem.Text = "Create Example DB";
            this.createExampleDBToolStripMenuItem.Click += new System.EventHandler(this.createExampleDBToolStripMenuItem_Click);
            // 
            // userComboBox
            // 
            this.userComboBox.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.userComboBox.FormattingEnabled = true;
            this.userComboBox.Items.AddRange(new object[] {
            "Employee",
            "Administrator"});
            this.userComboBox.Location = new System.Drawing.Point(161, 247);
            this.userComboBox.Name = "userComboBox";
            this.userComboBox.Size = new System.Drawing.Size(173, 21);
            this.userComboBox.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(110, 250);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(29, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "User";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(86, 282);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Password";
            // 
            // passwordTextBox
            // 
            this.passwordTextBox.Location = new System.Drawing.Point(161, 282);
            this.passwordTextBox.Name = "passwordTextBox";
            this.passwordTextBox.Size = new System.Drawing.Size(173, 20);
            this.passwordTextBox.TabIndex = 4;
            // 
            // loginButton
            // 
            this.loginButton.Location = new System.Drawing.Point(184, 324);
            this.loginButton.Name = "loginButton";
            this.loginButton.Size = new System.Drawing.Size(75, 23);
            this.loginButton.TabIndex = 5;
            this.loginButton.Text = "Login";
            this.loginButton.UseVisualStyleBackColor = true;
            this.loginButton.Click += new System.EventHandler(this.loginButton_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::GestAcaUI.Properties.Resources.Sin_nombre2;
            this.pictureBox1.Location = new System.Drawing.Point(76, 27);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(284, 200);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 6;
            this.pictureBox1.TabStop = false;
            // 
            // GestAcaApp
            // 
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.None;
            this.ClientSize = new System.Drawing.Size(434, 381);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.loginButton);
            this.Controls.Add(this.passwordTextBox);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.userComboBox);
            this.Controls.Add(this.menuStrip1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.menuStrip1;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MaximizeBox = false;
            this.MinimumSize = new System.Drawing.Size(450, 420);
            this.Name = "GestAcaApp";
            this.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.Text = "GestAcaApp";
            this.Load += new System.EventHandler(this.GestAcaApp_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem employeeToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem addEnrollmentToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem adToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem addTaughtCourseToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem assignTeacherToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem createExampleDBToolStripMenuItem;
        private System.Windows.Forms.ComboBox userComboBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox passwordTextBox;
        private System.Windows.Forms.Button loginButton;
        private System.Windows.Forms.PictureBox pictureBox1;
    }
}

