using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;

namespace TreView
{
    public partial class Form1 : Form
    {
        private XmlDocument xmlDoc;
        private string xmlFilePath;
        public Form1()
        {
            InitializeComponent();
        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {

        }

        private void buttonAdd_Click(object sender, EventArgs e)
        {
            string nodeName = textBox.Text.Trim();
            if (!string.IsNullOrEmpty(nodeName))
            {
                if (treeView1.Nodes.Count == 0)
                {
                    treeView1.Nodes.Add(nodeName);
                }
                else
                {
                    if (treeView1.SelectedNode != null)
                    {
                        TreeNode newNode = treeView1.SelectedNode.Nodes.Add(nodeName);
                        treeView1.SelectedNode = newNode;
                    }
                    else
                    {
                        MessageBox.Show("Chọn 1 NODE để thêm NODE mới.", "Error");
                    }
                }
            }
            else
            {
                MessageBox.Show("Hãy nhập tên NODE", "Error");
            }
        }

        private void buttonEdit_Click(object sender, EventArgs e)
        {
            string nodeName = textBox.Text.Trim();
            if (!string.IsNullOrEmpty(nodeName) && treeView1.SelectedNode != null)
            {
                treeView1.SelectedNode.Text = nodeName;
            }
        }

        private void buttonDelete_Click(object sender, EventArgs e)
        {
            if (treeView1.SelectedNode != null)
            {
                treeView1.SelectedNode.Remove();
            }
        }

        private void buttonFind_Click(object sender, EventArgs e)
        {
            string nodeName = textBox.Text.Trim();
            if (!string.IsNullOrEmpty(nodeName))
            {
                TreeNode foundNode = FindNode(treeView1.Nodes, nodeName);
                if (foundNode != null)
                {
                    treeView1.SelectedNode = foundNode;
                    treeView1.SelectedNode.EnsureVisible();
                    treeView1.Focus();
                    MessageBox.Show("đã tìm thấy NODE", "Sucess");
                }
                else
                {
                    MessageBox.Show("Không tìm thấy NODE ", "Error");
                }
            }
            else
            {
                MessageBox.Show("Hãy nhập nội dung cần tìm", "Error");
            }
        }

        private TreeNode FindNode(TreeNodeCollection nodes, string nodeName)
        {
           foreach (TreeNode node in nodes)
           {

               if (node.Text == nodeName)
               {
                   return node;
               }
               TreeNode foundNode = FindNode(node.Nodes, nodeName);

               if (foundNode != null)
               {
                   return foundNode;
               }
           }

            return null;
        }


        private void btnLoad_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog openFileDialog = new OpenFileDialog())
            {
                openFileDialog.Filter = "XML Files (*.xml)|*.xml";

                if (openFileDialog.ShowDialog() == DialogResult.OK)
                {
                    xmlFilePath = openFileDialog.FileName;
                    LoadXmlFile(xmlFilePath);
                }
            }
        }

        private void LoadXmlFile(string filePath)
        {
            try
            {
                xmlDoc = new XmlDocument();
                xmlDoc.Load(filePath);
                treeView1.Nodes.Clear();
                TreeNode rootNode = AddTreeNode(xmlDoc.DocumentElement);
                treeView1.Nodes.Add(rootNode);
                treeView1.ExpandAll();
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error loading XML file: {ex.Message}", "Error");
            }
        }
        private TreeNode AddTreeNode(XmlNode xmlNode)
        {
            TreeNode treeNode = new TreeNode(xmlNode.Name);
            foreach (XmlNode childNode in xmlNode.ChildNodes)
            {
                if (childNode.NodeType == XmlNodeType.Element)
                {
                    TreeNode childTreeNode = AddTreeNode(childNode);
                    treeNode.Nodes.Add(childTreeNode);
                }
                else if (childNode.NodeType == XmlNodeType.Text)
                {
                    treeNode.Nodes.Add(childNode.InnerText);
                }
            }
            return treeNode;
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            try
            {
                if (treeView1.Nodes.Count == 0)
                {
                    MessageBox.Show("Chưa có dữ liệu để lưu", "Error");
                    return;
                }

                if (string.IsNullOrEmpty(xmlFilePath)) 
                {
                    using (SaveFileDialog saveFileDialog = new SaveFileDialog())
                    {
                        saveFileDialog.Filter = "XML Files (*.xml)|*.xml";

                        if (saveFileDialog.ShowDialog() == DialogResult.OK)
                        {
                            xmlFilePath = saveFileDialog.FileName;
                        }
                        else
                        {
                            MessageBox.Show("Huy Luu File", "Error");
                            return;
                        }
                    }
                }

                XmlDocument newXmlDoc = new XmlDocument();
                XmlNode rootNode = newXmlDoc.CreateElement("Root");
                newXmlDoc.AppendChild(rootNode);

                SaveNodes(treeView1.Nodes, rootNode, newXmlDoc);

                newXmlDoc.Save(xmlFilePath);
                MessageBox.Show("Luu File Thành Công", "Success");
            }
            catch (Exception error)
            {
                MessageBox.Show($"Loi luu File: {error.Message}", "Error");
            }
        }

        private void SaveNodes(TreeNodeCollection nodes, XmlNode xmlNode, XmlDocument xmlDoc)
        {
            foreach (TreeNode node in nodes)
            {
                XmlNode newNode = xmlDoc.CreateElement("Node");
                newNode.InnerText = node.Text;
                xmlNode.AppendChild(newNode);

                if (node.Nodes.Count > 0)
                {
                    SaveNodes(node.Nodes, newNode, xmlDoc);
                }
            }
        }
    }
}
