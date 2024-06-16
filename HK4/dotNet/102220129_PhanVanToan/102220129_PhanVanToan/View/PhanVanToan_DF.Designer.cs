namespace _102220129_PhanVanToan.View
{
    partial class PhanVanToan_DF
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
            this.gbRent = new System.Windows.Forms.GroupBox();
            this.rdbtnCant = new System.Windows.Forms.RadioButton();
            this.rdbtnCan = new System.Windows.Forms.RadioButton();
            this.dtpkDate = new System.Windows.Forms.DateTimePicker();
            this.label5 = new System.Windows.Forms.Label();
            this.cbbCategory = new System.Windows.Forms.ComboBox();
            this.txtQuantity = new System.Windows.Forms.TextBox();
            this.txtName = new System.Windows.Forms.TextBox();
            this.txtId = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.btnCancel = new System.Windows.Forms.Button();
            this.btnOK = new System.Windows.Forms.Button();
            this.gbRent.SuspendLayout();
            this.SuspendLayout();
            // 
            // gbRent
            // 
            this.gbRent.Controls.Add(this.rdbtnCant);
            this.gbRent.Controls.Add(this.rdbtnCan);
            this.gbRent.Location = new System.Drawing.Point(329, 118);
            this.gbRent.Name = "gbRent";
            this.gbRent.Size = new System.Drawing.Size(198, 80);
            this.gbRent.TabIndex = 25;
            this.gbRent.TabStop = false;
            this.gbRent.Text = "Can be rented?";
            // 
            // rdbtnCant
            // 
            this.rdbtnCant.AutoSize = true;
            this.rdbtnCant.Location = new System.Drawing.Point(108, 36);
            this.rdbtnCant.Name = "rdbtnCant";
            this.rdbtnCant.Size = new System.Drawing.Size(39, 17);
            this.rdbtnCant.TabIndex = 1;
            this.rdbtnCant.TabStop = true;
            this.rdbtnCant.Text = "No";
            this.rdbtnCant.UseVisualStyleBackColor = true;
            // 
            // rdbtnCan
            // 
            this.rdbtnCan.AutoSize = true;
            this.rdbtnCan.Location = new System.Drawing.Point(31, 36);
            this.rdbtnCan.Name = "rdbtnCan";
            this.rdbtnCan.Size = new System.Drawing.Size(43, 17);
            this.rdbtnCan.TabIndex = 0;
            this.rdbtnCan.TabStop = true;
            this.rdbtnCan.Text = "Yes";
            this.rdbtnCan.UseVisualStyleBackColor = true;
            // 
            // dtpkDate
            // 
            this.dtpkDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpkDate.Location = new System.Drawing.Point(408, 52);
            this.dtpkDate.Name = "dtpkDate";
            this.dtpkDate.Size = new System.Drawing.Size(119, 20);
            this.dtpkDate.TabIndex = 24;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(311, 55);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(76, 13);
            this.label5.TabIndex = 23;
            this.label5.Text = "PublishedDate";
            // 
            // cbbCategory
            // 
            this.cbbCategory.FormattingEnabled = true;
            this.cbbCategory.Location = new System.Drawing.Point(132, 128);
            this.cbbCategory.Name = "cbbCategory";
            this.cbbCategory.Size = new System.Drawing.Size(121, 21);
            this.cbbCategory.TabIndex = 22;
            // 
            // txtQuantity
            // 
            this.txtQuantity.Location = new System.Drawing.Point(132, 169);
            this.txtQuantity.Name = "txtQuantity";
            this.txtQuantity.Size = new System.Drawing.Size(121, 20);
            this.txtQuantity.TabIndex = 21;
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(132, 89);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(121, 20);
            this.txtName.TabIndex = 20;
            // 
            // txtId
            // 
            this.txtId.Location = new System.Drawing.Point(132, 55);
            this.txtId.Name = "txtId";
            this.txtId.Size = new System.Drawing.Size(121, 20);
            this.txtId.TabIndex = 19;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(41, 172);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(46, 13);
            this.label4.TabIndex = 18;
            this.label4.Text = "Quantity";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(41, 131);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(49, 13);
            this.label3.TabIndex = 17;
            this.label3.Text = "Category";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(41, 92);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(63, 13);
            this.label2.TabIndex = 16;
            this.label2.Text = "Name Book";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(41, 58);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(46, 13);
            this.label1.TabIndex = 15;
            this.label1.Text = "ID Book";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // btnCancel
            // 
            this.btnCancel.Location = new System.Drawing.Point(314, 267);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(93, 38);
            this.btnCancel.TabIndex = 14;
            this.btnCancel.Text = "Cancel";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // btnOK
            // 
            this.btnOK.Location = new System.Drawing.Point(132, 267);
            this.btnOK.Name = "btnOK";
            this.btnOK.Size = new System.Drawing.Size(93, 38);
            this.btnOK.TabIndex = 13;
            this.btnOK.Text = "OK";
            this.btnOK.UseVisualStyleBackColor = true;
            this.btnOK.Click += new System.EventHandler(this.btnOK_Click);
            // 
            // PhanVanToan_DF
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(594, 356);
            this.Controls.Add(this.gbRent);
            this.Controls.Add(this.dtpkDate);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.cbbCategory);
            this.Controls.Add(this.txtQuantity);
            this.Controls.Add(this.txtName);
            this.Controls.Add(this.txtId);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnOK);
            this.Name = "PhanVanToan_DF";
            this.Text = "PhanVanToan_DF";
            this.gbRent.ResumeLayout(false);
            this.gbRent.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox gbRent;
        private System.Windows.Forms.RadioButton rdbtnCant;
        private System.Windows.Forms.RadioButton rdbtnCan;
        private System.Windows.Forms.DateTimePicker dtpkDate;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ComboBox cbbCategory;
        private System.Windows.Forms.TextBox txtQuantity;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.TextBox txtId;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.Button btnOK;
    }
}