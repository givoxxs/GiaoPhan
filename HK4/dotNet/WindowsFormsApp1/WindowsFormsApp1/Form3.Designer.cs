namespace WindowsFormsApp1
{
    partial class Form3
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
            this.txt31 = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // txt31
            // 
            this.txt31.Location = new System.Drawing.Point(56, 54);
            this.txt31.Name = "txt31";
            this.txt31.Size = new System.Drawing.Size(100, 20);
            this.txt31.TabIndex = 0;
            this.txt31.TextChanged += new System.EventHandler(this.txt31_TextChanged);
            // 
            // Form3
            // 
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.txt31);
            this.Name = "Form3";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txt31;
    }
}