namespace FastFoodOrder
{
    partial class Form1
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
            this.labelHeader = new System.Windows.Forms.Label();
            this.groupBoxListFood = new System.Windows.Forms.GroupBox();
            this.button15 = new System.Windows.Forms.Button();
            this.button14 = new System.Windows.Forms.Button();
            this.button13 = new System.Windows.Forms.Button();
            this.button12 = new System.Windows.Forms.Button();
            this.button11 = new System.Windows.Forms.Button();
            this.button10 = new System.Windows.Forms.Button();
            this.button9 = new System.Windows.Forms.Button();
            this.button8 = new System.Windows.Forms.Button();
            this.button7 = new System.Windows.Forms.Button();
            this.button6 = new System.Windows.Forms.Button();
            this.button5 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.buttonDel = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.comboBoxBill = new System.Windows.Forms.ComboBox();
            this.buttonOrder = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.groupBoxListFood.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // labelHeader
            // 
            this.labelHeader.AutoSize = true;
            this.labelHeader.BackColor = System.Drawing.Color.Transparent;
            this.labelHeader.Font = new System.Drawing.Font("Segoe UI", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelHeader.ForeColor = System.Drawing.Color.Blue;
            this.labelHeader.Location = new System.Drawing.Point(159, 53);
            this.labelHeader.Name = "labelHeader";
            this.labelHeader.Size = new System.Drawing.Size(214, 37);
            this.labelHeader.TabIndex = 0;
            this.labelHeader.Text = "FastFood Order";
            // 
            // groupBoxListFood
            // 
            this.groupBoxListFood.Controls.Add(this.button15);
            this.groupBoxListFood.Controls.Add(this.button14);
            this.groupBoxListFood.Controls.Add(this.button13);
            this.groupBoxListFood.Controls.Add(this.button12);
            this.groupBoxListFood.Controls.Add(this.button11);
            this.groupBoxListFood.Controls.Add(this.button10);
            this.groupBoxListFood.Controls.Add(this.button9);
            this.groupBoxListFood.Controls.Add(this.button8);
            this.groupBoxListFood.Controls.Add(this.button7);
            this.groupBoxListFood.Controls.Add(this.button6);
            this.groupBoxListFood.Controls.Add(this.button5);
            this.groupBoxListFood.Controls.Add(this.button4);
            this.groupBoxListFood.Controls.Add(this.button3);
            this.groupBoxListFood.Controls.Add(this.button2);
            this.groupBoxListFood.Controls.Add(this.button1);
            this.groupBoxListFood.Location = new System.Drawing.Point(25, 119);
            this.groupBoxListFood.Name = "groupBoxListFood";
            this.groupBoxListFood.Size = new System.Drawing.Size(398, 171);
            this.groupBoxListFood.TabIndex = 1;
            this.groupBoxListFood.TabStop = false;
            this.groupBoxListFood.Text = "Danh mục món ăn";
            // 
            // button15
            // 
            this.button15.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button15.ForeColor = System.Drawing.Color.Red;
            this.button15.Location = new System.Drawing.Point(332, 31);
            this.button15.Name = "button15";
            this.button15.Size = new System.Drawing.Size(51, 23);
            this.button15.TabIndex = 14;
            this.button15.Text = "Coca";
            this.button15.UseVisualStyleBackColor = true;
            this.button15.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button14
            // 
            this.button14.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button14.ForeColor = System.Drawing.Color.Red;
            this.button14.Location = new System.Drawing.Point(266, 30);
            this.button14.Name = "button14";
            this.button14.Size = new System.Drawing.Size(60, 24);
            this.button14.TabIndex = 13;
            this.button14.Text = "Pepsi";
            this.button14.UseVisualStyleBackColor = true;
            this.button14.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button13
            // 
            this.button13.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button13.ForeColor = System.Drawing.Color.Red;
            this.button13.Location = new System.Drawing.Point(332, 60);
            this.button13.Name = "button13";
            this.button13.Size = new System.Drawing.Size(51, 31);
            this.button13.TabIndex = 12;
            this.button13.Text = "Lipton";
            this.button13.UseVisualStyleBackColor = true;
            this.button13.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button12
            // 
            this.button12.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button12.ForeColor = System.Drawing.Color.Red;
            this.button12.Location = new System.Drawing.Point(265, 60);
            this.button12.Name = "button12";
            this.button12.Size = new System.Drawing.Size(61, 30);
            this.button12.TabIndex = 11;
            this.button12.Text = "7 up";
            this.button12.UseVisualStyleBackColor = true;
            this.button12.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button11
            // 
            this.button11.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button11.ForeColor = System.Drawing.Color.Red;
            this.button11.Location = new System.Drawing.Point(332, 97);
            this.button11.Name = "button11";
            this.button11.Size = new System.Drawing.Size(51, 29);
            this.button11.TabIndex = 10;
            this.button11.Text = "Cam";
            this.button11.UseVisualStyleBackColor = true;
            this.button11.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button10
            // 
            this.button10.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button10.ForeColor = System.Drawing.Color.Red;
            this.button10.Location = new System.Drawing.Point(265, 96);
            this.button10.Name = "button10";
            this.button10.Size = new System.Drawing.Size(61, 30);
            this.button10.TabIndex = 9;
            this.button10.Text = "Cafe";
            this.button10.UseVisualStyleBackColor = true;
            this.button10.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button9
            // 
            this.button9.ForeColor = System.Drawing.Color.ForestGreen;
            this.button9.Location = new System.Drawing.Point(265, 132);
            this.button9.Name = "button9";
            this.button9.Size = new System.Drawing.Size(118, 25);
            this.button9.TabIndex = 8;
            this.button9.Text = "Khoai tây chiên";
            this.button9.UseVisualStyleBackColor = true;
            this.button9.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button8
            // 
            this.button8.ForeColor = System.Drawing.Color.Blue;
            this.button8.Location = new System.Drawing.Point(141, 132);
            this.button8.Name = "button8";
            this.button8.Size = new System.Drawing.Size(118, 25);
            this.button8.TabIndex = 7;
            this.button8.Text = "Cơm gà tender";
            this.button8.UseVisualStyleBackColor = true;
            this.button8.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button7
            // 
            this.button7.ForeColor = System.Drawing.Color.Blue;
            this.button7.Location = new System.Drawing.Point(141, 96);
            this.button7.Name = "button7";
            this.button7.Size = new System.Drawing.Size(118, 29);
            this.button7.TabIndex = 6;
            this.button7.Text = "Gà rán phần";
            this.button7.UseVisualStyleBackColor = true;
            this.button7.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button6
            // 
            this.button6.ForeColor = System.Drawing.Color.Blue;
            this.button6.Location = new System.Drawing.Point(141, 60);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(118, 30);
            this.button6.TabIndex = 5;
            this.button6.Text = "Gà viên Cola";
            this.button6.UseVisualStyleBackColor = true;
            this.button6.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button5
            // 
            this.button5.ForeColor = System.Drawing.Color.Blue;
            this.button5.Location = new System.Drawing.Point(141, 31);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(118, 23);
            this.button5.TabIndex = 4;
            this.button5.Text = "Tôm viên Cola";
            this.button5.UseVisualStyleBackColor = true;
            this.button5.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button4
            // 
            this.button4.ForeColor = System.Drawing.Color.Red;
            this.button4.Location = new System.Drawing.Point(17, 132);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(118, 25);
            this.button4.TabIndex = 3;
            this.button4.Text = "Burger Phô mai Cá";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button3
            // 
            this.button3.ForeColor = System.Drawing.Color.Red;
            this.button3.Location = new System.Drawing.Point(17, 96);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(118, 29);
            this.button3.TabIndex = 2;
            this.button3.Text = "Burger Phô mai Tôm";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button2
            // 
            this.button2.ForeColor = System.Drawing.Color.Red;
            this.button2.Location = new System.Drawing.Point(17, 60);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(118, 30);
            this.button2.TabIndex = 1;
            this.button2.Text = "Burger Phô mai Gà";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // button1
            // 
            this.button1.ForeColor = System.Drawing.Color.Red;
            this.button1.Location = new System.Drawing.Point(17, 31);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(118, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "Burger Phô mai Bò";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.buttonFoodClick);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.Color.Transparent;
            this.pictureBox1.BackgroundImage = global::FastFoodOrder.Properties.Resources.final;
            this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox1.Location = new System.Drawing.Point(42, 28);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(106, 85);
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // buttonDel
            // 
            this.buttonDel.Location = new System.Drawing.Point(25, 296);
            this.buttonDel.Name = "buttonDel";
            this.buttonDel.Size = new System.Drawing.Size(82, 22);
            this.buttonDel.TabIndex = 3;
            this.buttonDel.Text = "🗑️ Delete";
            this.buttonDel.UseVisualStyleBackColor = true;
            this.buttonDel.Click += new System.EventHandler(this.buttonDel_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(113, 301);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(47, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "Tên bàn";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // comboBoxBill
            // 
            this.comboBoxBill.FormattingEnabled = true;
            this.comboBoxBill.Location = new System.Drawing.Point(166, 297);
            this.comboBoxBill.Name = "comboBoxBill";
            this.comboBoxBill.Size = new System.Drawing.Size(132, 21);
            this.comboBoxBill.TabIndex = 5;
            this.comboBoxBill.SelectedIndexChanged += new System.EventHandler(this.comboBoxBill_SelectedIndexChanged);
            // 
            // buttonOrder
            // 
            this.buttonOrder.Location = new System.Drawing.Point(315, 298);
            this.buttonOrder.Name = "buttonOrder";
            this.buttonOrder.Size = new System.Drawing.Size(93, 21);
            this.buttonOrder.TabIndex = 6;
            this.buttonOrder.Text = "🏷️ Order";
            this.buttonOrder.UseVisualStyleBackColor = true;
            this.buttonOrder.Click += new System.EventHandler(this.buttonOrder_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(25, 325);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(383, 147);
            this.dataGridView1.TabIndex = 7;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(442, 491);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.buttonOrder);
            this.Controls.Add(this.comboBoxBill);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.buttonDel);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.groupBoxListFood);
            this.Controls.Add(this.labelHeader);
            this.Name = "Form1";
            this.Text = "E-Order_Application";
            this.groupBoxListFood.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelHeader;
        private System.Windows.Forms.GroupBox groupBoxListFood;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Button button6;
        private System.Windows.Forms.Button button7;
        private System.Windows.Forms.Button button8;
        private System.Windows.Forms.Button button9;
        private System.Windows.Forms.Button button10;
        private System.Windows.Forms.Button button11;
        private System.Windows.Forms.Button button12;
        private System.Windows.Forms.Button button13;
        private System.Windows.Forms.Button button14;
        private System.Windows.Forms.Button button15;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button buttonDel;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox comboBoxBill;
        private System.Windows.Forms.Button buttonOrder;
        private System.Windows.Forms.DataGridView dataGridView1;
    }
}

