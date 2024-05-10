namespace ConnectSQLServer
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
            this.btnBeginConnect = new System.Windows.Forms.Button();
            this.btnCloseConnect = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnBeginConnect
            // 
            this.btnBeginConnect.Location = new System.Drawing.Point(148, 127);
            this.btnBeginConnect.Name = "btnBeginConnect";
            this.btnBeginConnect.Size = new System.Drawing.Size(102, 32);
            this.btnBeginConnect.TabIndex = 0;
            this.btnBeginConnect.Text = "Mở kết nối";
            this.btnBeginConnect.UseVisualStyleBackColor = true;
            this.btnBeginConnect.Click += new System.EventHandler(this.btnBeginConnect_Click);
            // 
            // btnCloseConnect
            // 
            this.btnCloseConnect.Location = new System.Drawing.Point(349, 127);
            this.btnCloseConnect.Name = "btnCloseConnect";
            this.btnCloseConnect.Size = new System.Drawing.Size(102, 33);
            this.btnCloseConnect.TabIndex = 1;
            this.btnCloseConnect.Text = "Đóng kết nối";
            this.btnCloseConnect.UseVisualStyleBackColor = true;
            this.btnCloseConnect.Click += new System.EventHandler(this.btnCloseConnect_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.btnCloseConnect);
            this.Controls.Add(this.btnBeginConnect);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnBeginConnect;
        private System.Windows.Forms.Button btnCloseConnect;
    }
}

