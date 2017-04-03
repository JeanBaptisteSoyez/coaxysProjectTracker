using CoaxysProjectTracker.Services;
using CoaxysProjectTracker.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using CoaxysProjectTracker.Attributes;
using CoaxysProjectTracker.Repositories;

namespace CoaxysProjectTracker.Controllers
{
    [CustomAuthorize]
    public class EpicController : Controller
    {
        protected EpicRepository repository;

        public EpicController()
        {
            repository = new EpicRepository();
        }
        
        public async Task<ActionResult> Index()
        {
            var epics = await repository.GetEpics();
            return View(epics);
        }

        public ActionResult Create()
        {
            return View();
        }

        public async Task<ActionResult> Edit(int id)
        {
            var epic = await repository.GetEpicByID(id);
            return View(epic);
        }

    }

}
