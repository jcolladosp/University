﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código se generó mediante una herramienta.
//     Los cambios del archivo se perderán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------
namespace GestAcaLib.Entities
{
	
	using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations.Schema;


    public partial class Course
	{
		public string Description
		{
			get;
			set;
		}

		public string Name
		{
			get;
			set;
		}

        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int Id
		{
			get;
			set;
		}

		public virtual ICollection<TaughtCourse> TaughtCourses
		{
			get;
			set;
		}

	}
}
